/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.servbyte.DeliveryService.model;

import java.io.Serializable;
import java.time.Duration;
import javax.persistence.Convert;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author hp 1030 g2
 */
@Entity
public class Meal  extends Service implements Serializable{
    
    @Convert(converter = DurationConverter.class)
    @Setter@Getter private Duration preparationTime;
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Meal)) {
            return false;
        }
        Meal other = (Meal) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.servbyte.DeliveryService.model.Meal[ id=" + getId() + " ]";
    }
    
}
