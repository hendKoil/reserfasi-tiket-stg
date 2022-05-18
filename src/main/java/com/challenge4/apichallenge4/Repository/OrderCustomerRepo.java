package com.challenge4.apichallenge4.Repository;

import com.challenge4.apichallenge4.Entity.OrderCustomer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderCustomerRepo extends JpaRepository<OrderCustomer, Integer> {

}
