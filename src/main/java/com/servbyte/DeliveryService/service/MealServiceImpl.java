/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servbyte.DeliveryService.service;

import com.servbyte.DeliveryService.model.Meal;
import com.servbyte.DeliveryService.repository.MealRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hp 1030 g2
 */
public class MealServiceImpl extends AbstractService<Meal,Long>{
    @Autowired
    private MealRepository repository;
    
    public MealServiceImpl(){
        super(Meal.class);
    }
    
    @Override
    protected JpaRepository<Meal, Long> getJpaRepository(){
        return repository;
    }
    
    @Override
    public Meal updateEntity(Meal meal, Long id) {
        final Optional<Meal> optional = Optional.empty();
        repository.findById(id).ifPresent(dbMeal ->
        {
            dbMeal.setDescription(meal.getDescription());
            dbMeal.setPicture(meal.getPicture());
            dbMeal.setPreparationTime(meal.getPreparationTime());
            dbMeal.setPrice(meal.getPrice());
            Optional.of(repository.save(dbMeal));
        });
        return optional.get();// throws NoSuchElementException if empty
    }
}
