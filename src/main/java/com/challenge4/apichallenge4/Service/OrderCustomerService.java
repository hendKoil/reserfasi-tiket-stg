package com.challenge4.apichallenge4.Service;

import com.challenge4.apichallenge4.Dto.OrderCustomerDto;
import com.challenge4.apichallenge4.Entity.*;
import com.challenge4.apichallenge4.Repository.FilmsRepo;

import com.challenge4.apichallenge4.Repository.OrderCustomerRepo;
import com.challenge4.apichallenge4.Repository.SchedulesRepo;
import com.challenge4.apichallenge4.Repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderCustomerService {
    @Autowired
    OrderCustomerRepo orderCustomerRepo;

    @Autowired
    SchedulesRepo schedulesRepo;

    @Autowired
    FilmsRepo filmsRepo;

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    MasterStudioService masterStudioService;

    public void submitOrder(OrderCustomerDto orderCustomerDto){
        OrderCustomer orderCustomer = new OrderCustomer();
        try {
            Schedules schedules = schedulesRepo.findById(orderCustomerDto.getSchedules_id());
            Films films = filmsRepo.findByFilmCode(orderCustomerDto.getFilmCode());
            Users users = usersRepo.findById(orderCustomerDto.getUsers());

            MasterStudio studio =  masterStudioService.updateStatusStudio(orderCustomerDto.getIdSeat(), orderCustomerDto.isStatus());

            orderCustomer.setIdSeat(orderCustomerDto.getIdSeat());
            orderCustomer.setFilmCode(films.getFilmCode());
            orderCustomer.setSchedules_id(schedules.getId());
            orderCustomer.setIdUser(users);

             orderCustomerRepo.save(orderCustomer);
        }catch (Exception e){
            e.printStackTrace();

        }

    }

}

