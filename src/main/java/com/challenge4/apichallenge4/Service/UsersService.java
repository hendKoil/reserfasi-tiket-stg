package com.challenge4.apichallenge4.Service;



import com.challenge4.apichallenge4.Dto.FilmsDto;
import com.challenge4.apichallenge4.Dto.SchedulesDto;
import com.challenge4.apichallenge4.Dto.UsersDto;
import com.challenge4.apichallenge4.Entity.Films;
import com.challenge4.apichallenge4.Entity.Schedules;
import com.challenge4.apichallenge4.Entity.Users;
import com.challenge4.apichallenge4.Repository.FilmsRepo;
import com.challenge4.apichallenge4.Repository.SchedulesRepo;
import com.challenge4.apichallenge4.Repository.UsersRepo;
import com.challenge4.apichallenge4.Repository.UsersRepo1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//Suatu kelas yang berhubungan dengan logic kita, pengimplementasi pada kelas repository dan kelas controller

@Service //depedency injection : memberi tahu springboot bahwa ini kelas service
public class UsersService {
    @Autowired //notation yang gunanya untuk mengimport suatu kelas
    UsersRepo usersRepo;
    @Autowired
    UsersRepo1 usersRepo1;

    public UsersService(UsersRepo usersRepo) {
        this.usersRepo = usersRepo;
    }


    public Users submit_users(UsersDto usersDto){
        Users users = new Users();
        users.setUsername(usersDto.getUsername());
        users.setEmail(usersDto.getEmail());
        users.setPassword(usersDto.getPassword());

        return usersRepo.save(users);
    }

    public List<Users> list_users(){
        return usersRepo.findAll();
    }

    public void update_users(int id, UsersDto usersDto){
        try {
            Users users = usersRepo.findById(id);
            if (users != null){
                users.setUsername(usersDto.getUsername());
                users.setEmail(usersDto.getEmail());
                users.setPassword(usersDto.getPassword());
            }
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("user not found");
        }
    }
    public List<Users> users_by_id(int id){
        return usersRepo1.findById(id);
    }
    public List<Users> delete_by_id(int id){
        Users delete = usersRepo.findById(id);
        if (delete != null){
            usersRepo.deleteById(id);
        }
        return usersRepo.findAll();
    }


}
