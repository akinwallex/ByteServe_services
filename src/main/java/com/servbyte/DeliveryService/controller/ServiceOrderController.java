/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servbyte.DeliveryService.controller;

import com.servbyte.DeliveryService.model.Meal;
import com.servbyte.DeliveryService.model.ServiceOrder;
import com.servbyte.DeliveryService.service.MealServiceImpl;
import com.servbyte.DeliveryService.service.OrderServiceImpl;
import java.net.URI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp 1030 g2
 */
@RestController
@RequestMapping(value = "/order")
public class ServiceOrderController extends AbstractController<ServiceOrder,Long>{
    @Autowired
    private OrderServiceImpl service;
    public ServiceOrderController(){
        super(ServiceOrder.class);
    }
    @Override
    protected OrderServiceImpl getServiceImpl(){
        return service;
    }
    
    @PostMapping(value="/add")
    @Override
    public ResponseEntity<Object> create(@RequestBody ServiceOrder serviceOrder){
        ServiceOrder newServiceOrder = (ServiceOrder)super.create(serviceOrder).getBody();
        return new ResponseEntity<>(
                URI.create("/order/search/"+newServiceOrder.getId()),
                HttpStatus.CREATED);
    }
}
