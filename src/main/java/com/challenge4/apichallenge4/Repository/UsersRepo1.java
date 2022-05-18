package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UsersRepo1 extends JpaRepository<Users, Integer> {
    public List<Users> findById(int id);
}
