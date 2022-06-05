
//package com.challenge4.apichallenge4;
//
//import com.challenge4.apichallenge4.Repository.UsersRepo;
//import com.challenge4.apichallenge4.Service.UsersService;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.junit.jupiter.MockitoExtension;
//
//@ExtendWith(MockitoExtension.class)
//class UserCustomerTest {
//
//    @Mock private UsersRepo usersRepo;
//
//    private UsersService usersService;
//
//    @BeforeEach void setUp()
//    {
//        this.usersService
//                = new UsersService(this.usersRepo);
//    }
//
//    @Test void getAllPerson()
//    {
//        usersService.list_users();
//        Mockito.verify(usersRepo).findAll();
//    }
//}
