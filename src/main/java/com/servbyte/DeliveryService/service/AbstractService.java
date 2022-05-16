/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servbyte.DeliveryService.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author hp 1030 g2
 */
public abstract class AbstractService<T,ID> {
    private Class<T> entityClass;
    
    public AbstractService(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    
    protected abstract JpaRepository<T,ID> getJpaRepository();
    
    public T saveEntity(T entity){
        return getJpaRepository().save(entity);
    }
  
    // read operation
    public List<T> fetchEntityList(){
        return getJpaRepository().findAll();
    }
  
    // update operation
    public abstract T updateEntity(T entity, ID entityId);
  
    // delete operation
    public void deleteEntityById(ID entityId){
        getJpaRepository().deleteById(entityId);
    }
    
    public T getEntityById(ID entityId){
        return getJpaRepository().findById(entityId).get();
    }
}
