package com.challenge4.apichallenge4.Service;

import com.challenge4.apichallenge4.Entity.UserLogin;

public interface UserService {
    UserLogin saveUser(UserLogin userLogin);
    UserLogin findByUserName(String username);

}
