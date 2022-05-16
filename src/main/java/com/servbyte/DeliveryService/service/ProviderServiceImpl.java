/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servbyte.DeliveryService.service;

import com.servbyte.DeliveryService.model.Meal;
import com.servbyte.DeliveryService.model.ServiceProvider;
import com.servbyte.DeliveryService.repository.ServiceProviderRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hp 1030 g2
 */
public class ProviderServiceImpl extends AbstractService<ServiceProvider,Long>{
    @Autowired
    private ServiceProviderRepository repository;
    
    public ProviderServiceImpl(){
        super(ServiceProvider.class);
    }
    
    @Override
    protected JpaRepository<ServiceProvider, Long> getJpaRepository(){
        return repository;
    }
    
    @Override
    public ServiceProvider updateEntity(ServiceProvider provider, Long id) {
        final Optional<ServiceProvider> optional = Optional.empty();
        repository.findById(id).ifPresent(dbProvider ->
        {
            dbProvider.setCity(provider.getCity());
            dbProvider.setEmail(provider.getEmail());
            dbProvider.setLogo(provider.getLogo());
            dbProvider.setPhoneNumber(provider.getPhoneNumber());
            dbProvider.setRestaurantName(provider.getRestaurantName());
            dbProvider.setServiceCategory(provider.getServiceCategory());
            dbProvider.setServices(provider.getServices());
            Optional.of(repository.save(dbProvider));
        });
        return optional.get();// throws NoSuchElementException if empty
    }
}
