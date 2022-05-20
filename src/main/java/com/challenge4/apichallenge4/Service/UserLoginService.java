package com.challenge4.apichallenge4.Service;

import com.challenge4.apichallenge4.Entity.UserLogin;
import com.challenge4.apichallenge4.Repository.RoleRepository;
import com.challenge4.apichallenge4.Repository.UserLoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserLoginService implements UserDetailsService {
    UserLoginRepository userLoginRepository;
    RoleRepository roleRepository;

    private PasswordEncoder passwordEncoder;


    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin userLogin  = userLoginRepository.findByUserName(username);
        if(userLogin == null){
            throw new UsernameNotFoundException("user not found");
        }else{
            System.out.println(username+ "found.!!");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        userLogin.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getRole()));
        });

        return new org.springframework.security.core.userdetails.User(userLogin.getUserName(), userLogin.getPassword(), authorities);
    }
    public void setUserLoginRepository(UserLogin userLogin) {
       UserLogin saveUserLogin = new UserLogin();
       saveUserLogin.setUserName(userLogin.getUserName());
//       passwordEncoder.encode(userLogin.getPassword()).toString();
        saveUserLogin.setActive(userLogin.getActive());
       saveUserLogin.setPassword(userLogin.getPassword());
       saveUserLogin.setName(userLogin.getName());
       saveUserLogin.setEmail(userLogin.getEmail());
       saveUserLogin.setLastName(userLogin.getLastName());
       saveUserLogin.setRoles(userLogin.getRoles());

       userLoginRepository.save(saveUserLogin);
    }
    public UserLogin findByUsername(String userName){
       return userLoginRepository.findByUserName(userName);

    }
}
