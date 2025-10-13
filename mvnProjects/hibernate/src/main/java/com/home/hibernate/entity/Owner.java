package com.home.hibernate.entity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Owner
{
   @Id
   @GeneratedValue( strategy = GenerationType.IDENTITY )
   private int               id;
   private String            name;
   @OneToMany( mappedBy = "owner" )
   private Collection<House> house = new ArrayList<House>();

   public int getId()
   {
      return id;
   }

   public void setId( int id )
   {
      this.id = id;
   }

   public Collection<House> getHouse()
   {
      return house;
   }

   public void setHouse( Collection<House> house )
   {
      this.house = house;
   }

   public String getName()
   {
      return name;
   }

   public void setName( String name )
   {
      this.name = name;
   }

   public Owner()
   {}

   public Owner( String name )
   {
      this.name = name;
   }

}
