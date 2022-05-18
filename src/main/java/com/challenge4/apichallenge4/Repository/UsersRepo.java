package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

//pengoperasian DB, Select, update, save, delete
//untuk syntax query db
// dalam Jpa kelas entity dan tipe data Id

@Transactional
@Repository
public interface UsersRepo extends JpaRepository<Users, Integer> {

    public List<Users> findAll();
    public Users findById(int id);

}
