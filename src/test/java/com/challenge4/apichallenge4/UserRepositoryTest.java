package com.challenge4.apichallenge4;


import com.challenge4.apichallenge4.Entity.Users;
import com.challenge4.apichallenge4.Repository.UsersRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = ApiChallenge4Application.class)
public class UserRepositoryTest {
    @Autowired
    UsersRepo usersRepo;

    @Test
    public void testFindById() {
        Users user = getCustomer();
        Users userFound = usersRepo.findById(user.getId_users());
        assertEquals(user.getId_users(), userFound.getId_users());
    }

    @Test
    public void testSave() {
        Users customer = getCustomer();
        usersRepo.save(customer);
        Users found = usersRepo.findById(customer.getId_users());
        assertEquals(customer.getId_users(), found.getId_users());
    }

    private Users getCustomer() {
        Users users = new Users();
        users.setId_users(1);
        users.setUsername("test");
        users.setPassword("test");
        users.setEmail("test@test.com");

        return users;
    }
}
