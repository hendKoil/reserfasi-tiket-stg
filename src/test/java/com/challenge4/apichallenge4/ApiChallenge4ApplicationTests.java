package com.challenge4.apichallenge4;

import com.challenge4.apichallenge4.Controller.UsersController;
import com.challenge4.apichallenge4.Dto.UsersDto;
import com.challenge4.apichallenge4.Service.UsersService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ApiChallenge4ApplicationTests {

    private MockMvc mockMvc;

    @Mock
    private UsersService usersService;
    @InjectMocks
    private UsersController usersController;
    @Mock
    private FilterChainProxy springSecurityFilterChain;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    void setUp() {
        MockMvc mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .alwaysDo(print())
                .apply(SecurityMockMvcConfigurers.springSecurity(springSecurityFilterChain))
                .build();
    }

    @WithMockUser("/submit-user-test-1")
    @Test
    public void testSaveCustomer() throws Exception {
        UsersDto cusotmer = new UsersDto(1, "user8", "xxx@gmail.com", "mantul");
        MockHttpServletRequest request = new MockHttpServletRequest();
        RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));

        when(usersService.submit_users(any(UsersDto.class))).thenReturn(true);
        ResponseEntity<Object> responseEntity = usersController.submit_controller(cusotmer);
        assertThat(responseEntity.getStatusCodeValue()).isEqualTo(202);
    }
}
