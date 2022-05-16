/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servbyte.DeliveryService.controller;

import com.servbyte.DeliveryService.model.Meal;
import com.servbyte.DeliveryService.service.MealServiceImpl;
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
@RequestMapping(value = "/meal")
public class MealController extends AbstractController<Meal,Long>{
    
    @Autowired
    private MealServiceImpl service;
    public MealController(){
        super(Meal.class);
    }
    @Override
    protected MealServiceImpl getServiceImpl(){
        return service;
    }
    
    @PostMapping(value="/add")
    @Override
    public ResponseEntity<Object> create(@RequestBody Meal mealService){
        Meal newMealService = (Meal)super.create(mealService).getBody();
        return new ResponseEntity<>(
                URI.create("/meal/search/"+newMealService.getId()),
                HttpStatus.CREATED);
    }
}
