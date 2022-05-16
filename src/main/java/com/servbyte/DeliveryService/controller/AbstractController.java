/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servbyte.DeliveryService.controller;

import com.servbyte.DeliveryService.service.AbstractService;
import java.util.List;
import java.util.NoSuchElementException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author hp 1030 g2
 */
public abstract class AbstractController <T extends Object,ID>{
    private Class<T> entityClass;
    
    public AbstractController(Class<T> entityClass) {
        this.entityClass = entityClass;
    }
    protected abstract AbstractService<T,ID> getServiceImpl();
    @PostMapping(value="/add")
    public ResponseEntity<Object> create(@RequestBody T entity){
        T newEntity = getServiceImpl().saveEntity(entity);
        return new ResponseEntity<>(newEntity,HttpStatus.CREATED);
    }
    @GetMapping(value = "/search/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id")ID id){
        T dbEntity = getServiceImpl().getEntityById(id);
        return new ResponseEntity<>(dbEntity,HttpStatus.FOUND);
    }
    @PutMapping(value="/update/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") ID id,@RequestBody T entity){
        T updatedEntity = null;
        try{
            updatedEntity = getServiceImpl().updateEntity(entity, id);
        }catch(NoSuchElementException ex){
            return new ResponseEntity<>("Enttity not updated - No such element",HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(updatedEntity,HttpStatus.OK);
    }
    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity<Object> removeById(@PathVariable("id") ID id){
        getServiceImpl().deleteEntityById(id);
        return new ResponseEntity<>("Entity removed successfully",HttpStatus.OK);
    }
    @GetMapping(value = "/search/all")
    public ResponseEntity<Object> findAll(
            @RequestParam(name="pageIndex", required=false,defaultValue="0")Integer pageIndex,
            @RequestParam(name="size", required=false, defaultValue="10")Integer size)
    {
        List<T> entityList = getServiceImpl().fetchEntityList();
        if(entityList.isEmpty())
             return new ResponseEntity<>("Entities not found",HttpStatus.NOT_FOUND);
        if(pageIndex ==0 && size ==0)
            return new ResponseEntity<>(entityList,HttpStatus.OK);
        
            int entityCount = entityList.size();
            int pageCount;
            int fromIndex=0;
            int toIndex = entityCount;
            if(size>=1){
                pageCount = (int)Math.ceil(entityCount/size);// always round up the result of entityCount/size
                if(pageIndex>=0 && pageIndex<pageCount)
                    fromIndex = pageIndex*size;
                if((fromIndex+size) <= entityCount)
                    toIndex = fromIndex+size;
            }//returns a view of the portion of the entity list between the inclusive and exclusive parameters
        return new ResponseEntity<>(entityList.subList(fromIndex, toIndex),HttpStatus.OK);
    }
}
