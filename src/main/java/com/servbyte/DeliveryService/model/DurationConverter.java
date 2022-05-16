/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servbyte.DeliveryService.model;

import java.time.Duration;
import javax.persistence.AttributeConverter;

/**
 *
 * @author hp 1030 g2
 */
public class DurationConverter implements AttributeConverter<Duration, Long>{
    @Override
    public Long convertToDatabaseColumn(
            Duration attribute) {
        if (attribute != null) {
            return (long) attribute.toMinutes();
        }
        return null;
    }
 
    @Override
    public Duration convertToEntityAttribute(
            Long dbData) {
        if (dbData != null) {
            return Duration.ofMinutes(dbData);
        }
        return null;
    }
}
