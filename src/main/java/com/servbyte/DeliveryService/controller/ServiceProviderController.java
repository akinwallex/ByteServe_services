/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servbyte.DeliveryService.controller;

import com.servbyte.DeliveryService.model.City;
import com.servbyte.DeliveryService.model.Meal;
import com.servbyte.DeliveryService.model.ServiceProvider;
import com.servbyte.DeliveryService.service.ProviderServiceImpl;
import java.net.URI;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp 1030 g2
 */
@RestController
@RequestMapping(value = "/provider")
public class ServiceProviderController extends AbstractController<ServiceProvider,Long>{
    @Autowired
    private ProviderServiceImpl service;
    private static int NO_PAGE_INDEX = 0;
    private static int NO_PAGE_SIZE = 0;
    
    public ServiceProviderController(){
        super(ServiceProvider.class);
    }
    @Override
    protected ProviderServiceImpl getServiceImpl(){
        return service;
    }
    
    @PostMapping(value="/add")
    @Override
    public ResponseEntity<Object> create(@RequestBody ServiceProvider provider){
        ServiceProvider newProvider = (ServiceProvider)super.create(provider).getBody();
        return new ResponseEntity<>(
                URI.create("/provider/search/"+newProvider.getId()),
                HttpStatus.CREATED);
    }
    
    @GetMapping(value = "/search/city")// find all providers in a particular city
    public ResponseEntity<Object> findAllByCity(
            @RequestParam(name="city", required=true)City city)
    {
       List<ServiceProvider> providers =
            ((List<ServiceProvider>)findAll(NO_PAGE_INDEX,NO_PAGE_SIZE).getBody()).
               stream().
               filter(provider -> !provider.getCity().equals(city)). // filter out all providers not in the specified city
               toList();
       return new ResponseEntity<>(providers,HttpStatus.OK);
    }
}
