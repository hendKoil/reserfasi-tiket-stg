package com.challenge4.apichallenge4.Controller;

import com.challenge4.apichallenge4.Dto.UsersDto;
import com.challenge4.apichallenge4.Entity.Users;
import com.challenge4.apichallenge4.Service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsersController {
    @Autowired
    UsersService usersService;

    //RB Buat request body json
    //PV untuk url parameter (localhost:8081/api/pengeluaran/1)
    @PostMapping("api/users/submit")
    public Users submit_controller(@RequestBody UsersDto usersDto){

        return usersService.submit_users(usersDto);
    }
    @GetMapping("api/users")
    public List<Users> list_users_ctr(){
        return usersService.list_users();
    }
    @PutMapping("/api/users/{id}")
    public void update_users_ctr(@PathVariable int id, @RequestBody UsersDto usersDto){
        usersService.update_users(id, usersDto);
    }
    @GetMapping("api/users-by-id/{id}")
    public List<Users> get_by_id_ctr(@PathVariable ("id") int id){
        return usersService.users_by_id(id);
    }
    @DeleteMapping("api/users-delete-by-id/{id}")
    public List<Users> delete_by_id_ctr(@PathVariable ("id") int id){
        return usersService.delete_by_id(id);
    }

}
