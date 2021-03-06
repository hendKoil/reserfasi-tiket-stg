package com.challenge4.apichallenge4.Controller;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.challenge4.apichallenge4.Entity.Role;
import com.challenge4.apichallenge4.Entity.UserLogin;

import com.challenge4.apichallenge4.Service.ServiceImpl.UserServiceImpl;
//import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class LoginController {
//    @Autowired
//    LoginOAuth loginOAuth;

    @Autowired
//    private UserLoginRepository userService;
    UserServiceImpl UserServiceImpl;


    @PostMapping(value = "/registration")
    public ResponseEntity<?> createNewUser(@RequestBody UserLogin user) {
        Map<UserLogin, String> map = new HashMap<>();
        UserLogin userExists = UserServiceImpl.findByUserName(user.getUserName());
        if (userExists != null) {
            map.put(userExists,"userName error.user sudah ada");
            return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
        } else {
            UserServiceImpl.saveUser(user);
        }
        return  new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/refresh-token")
   public void refreshTokenController(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String authorizationHeader = request.getHeader(AUTHORIZATION);
        if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")){

            try {
                String refresh_token = authorizationHeader.substring("Bearer ".length());
                Algorithm algorithm = Algorithm.HMAC256("mantul".getBytes());
                JWTVerifier jwtVerifier = JWT.require(algorithm).build();
                DecodedJWT decodedJWT = jwtVerifier.verify(refresh_token);
                String usernameDecode = decodedJWT.getSubject();
                UserLogin userLogin = UserServiceImpl.findByUserName(usernameDecode);
                String accessToken = JWT.create()
                        .withSubject(userLogin.getUserName())
                        .withExpiresAt(new Date(System.currentTimeMillis() +10*60*1000))
                        .withIssuer(request.getRequestURL().toString())
                        .withClaim("roles", userLogin.getRoles().stream().map(Role::getRole).collect(Collectors.toList()))
                        .sign(algorithm);

                Map<String,String> map = new HashMap<>();
                map.put("access_token", accessToken);
                map.put("refresh_token", refresh_token);
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), map);
            }catch (Exception e){
                response.setHeader("error", e.getMessage());
                response.setStatus(FORBIDDEN.value());

                Map<String,String> errorMap = new HashMap<>();
                errorMap.put("error_message", e.getMessage());
                response.setContentType(APPLICATION_JSON_VALUE);
                new ObjectMapper().writeValue(response.getOutputStream(), errorMap);
            }

        }else{
           throw new RuntimeException("refresh token is missing");
        }
    }

//    @PostMapping(value="/admin/home")
//    public ResponseEntity<?> home(@RequestBody UserLogin userLogin){
//
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        UserLogin user = loginOAuth.findUserByUserName(auth.getName());
//        Map<String, Object> map = new HashMap<>();
//        map.put("login sebagai", user);
//        return new ResponseEntity<>(map, HttpStatus.OK);
//    }
//



}
