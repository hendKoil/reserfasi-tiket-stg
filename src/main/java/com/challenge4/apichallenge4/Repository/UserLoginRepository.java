package com.challenge4.apichallenge4.Repository;


import com.challenge4.apichallenge4.Entity.UserLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface UserLoginRepository extends JpaRepository<UserLogin, Long> {
   public UserLogin findByEmail(String email);
    public UserLogin findByUserName(String userName);
}
