
package com.challenge4.apichallenge4.Service.ServiceImpl;

import com.challenge4.apichallenge4.Controller.OrderController;
import com.challenge4.apichallenge4.Dto.UserLoginDto;
import com.challenge4.apichallenge4.Entity.UserLogin;
import com.challenge4.apichallenge4.Repository.UserLoginRepository;
import com.challenge4.apichallenge4.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements  UserDetailsService {
    @Autowired
    private  final UserLoginRepository userLoginRepository;
    private  final PasswordEncoder passwordEncoder;

    private final Logger logger = LogManager.getLogger(UserServiceImpl.class);

    public UserLogin saveUser(UserLoginDto userLogin) throws IOException {
        UserLogin save = new UserLogin();
        save.setRoles(userLogin.getRoles());
        save.setActive(userLogin.getActive());
        save.setName(userLogin.getName());
        save.setUserName(userLogin.getUserName());
        save.setLastName(userLogin.getLastName());
        save.setEmail(userLogin.getEmail());
        save.setImg(userLogin.getImg().getBytes());
        save.setPassword(passwordEncoder.encode(userLogin.getPassword()));

        return userLoginRepository.save(save);
    }

    public UserLogin findByUserName(String username) {
        return userLoginRepository.findByUserName(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserLogin user = userLoginRepository.findByUserName(username);
        if(user == null ){
            logger.error("user not found");
        }else{
            logger.info(username+ "found .!");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> authorities.add(new SimpleGrantedAuthority(role.getRole())));
        return new org.springframework.security.core.userdetails.
                User(user.getUserName(), user.getPassword(), authorities);
    }
}
