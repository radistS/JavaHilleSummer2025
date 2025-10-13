package com.home.hibernate;

import com.home.hibernate.entity.Insurance;
import com.home.hibernate.entity.Person;
import com.home.hibernate.entity.Vehicle;
import org.hibernate.Session;

import java.util.List;

public class RunExample {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Person person = new Person();
        person.setFirstName("Oleksanr");
        person.setLastName("Stepurko");
        person.setEmail("test@email.com");
        Vehicle vehicle = new Vehicle("ford");

        person.setVehicle(vehicle);
        List<Insurance> insurances = List.of(
                new Insurance("car", "12"),
                new Insurance("plane", "2"),
                new Insurance("house", "5")
        );
        person.setInsurances(insurances);

        session.beginTransaction();
        session.save(vehicle);
        session.save( person );
        session.getTransaction().commit();


        Person p1 = (Person) session.get( Person.class, 1L );

        System.out.println(p1);

        HibernateUtil.shutdown();
    }
}
