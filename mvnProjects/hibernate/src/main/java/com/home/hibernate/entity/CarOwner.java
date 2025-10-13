package com.home.hibernate.entity;

import lombok.Data;
import org.hibernate.annotations.common.test.reflection.java.TestAnnotation;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.*;

@Entity
@Data
@Table(name = "carowner")
public class CarOwner
{
   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY )
   private int             id;
   private String          name;
   @Transient
   private String          details;
   @ManyToMany( cascade = CascadeType.ALL, mappedBy = "owners" )
   private Collection<Car> cars = new ArrayList<>();


   public CarOwner( String name )
   {
      this.name = name;
   }


}
