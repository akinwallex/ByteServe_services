/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servbyte.DeliveryService.service;

import com.servbyte.DeliveryService.model.ServiceOrder;
import com.servbyte.DeliveryService.model.ServiceProvider;
import com.servbyte.DeliveryService.repository.ServiceOrderRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hp 1030 g2
 */
public class OrderServiceImpl extends AbstractService<ServiceOrder,Long>{
    @Autowired
    private ServiceOrderRepository repository;
    
    public OrderServiceImpl(){
        super(ServiceOrder.class);
    }
    
    @Override
    protected JpaRepository<ServiceOrder, Long> getJpaRepository(){
        return repository;
    }
    
    @Override
    public ServiceOrder updateEntity(ServiceOrder serviceOrder, Long id) {
        final Optional<ServiceOrder> optional = Optional.empty();
        repository.findById(id).ifPresent(dbServiceOrder ->
        {
            dbServiceOrder.setServices(serviceOrder.getServices());
            Optional.of(repository.save(dbServiceOrder));
        });
        return optional.get();// throws NoSuchElementException if empty
    }
}
