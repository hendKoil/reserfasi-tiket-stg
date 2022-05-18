package com.challenge4.apichallenge4.Controller;

import com.challenge4.apichallenge4.Dto.OrderCustomerDto;
import com.challenge4.apichallenge4.Entity.OrderCustomer;
import com.challenge4.apichallenge4.Service.OrderCustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("api/")

public class OrderController {
    @Autowired
    OrderCustomerService orderCustomerService;

    Logger logger = LogManager.getLogger(OrderController.class);

    @PostMapping("order")
    public ResponseEntity<?> submit_order(@RequestBody OrderCustomerDto orderCustomerDto){
        orderCustomerService.submitOrder(orderCustomerDto);

        return  new ResponseEntity<>(HttpStatus.CREATED);
    }
}
