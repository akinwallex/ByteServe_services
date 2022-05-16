/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.servbyte.DeliveryService.repository;

import com.servbyte.DeliveryService.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hp 1030 g2
 */
public interface MealRepository extends JpaRepository<Meal,Long>{
    
}
