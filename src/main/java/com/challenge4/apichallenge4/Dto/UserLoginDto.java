package com.challenge4.apichallenge4.Dto;

import com.challenge4.apichallenge4.Entity.Role;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.Column;
import javax.persistence.Lob;
import java.util.List;

@Setter
@Getter
public class UserLoginDto {
    private int id;
    private String userName;
    private String email;
    private String password;
    private String name;
    private String lastName;
    private Boolean active;
    private List<Role> roles;
    private MultipartFile img;

}
