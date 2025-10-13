package com.home.hibernate;

import com.home.hibernate.entity.Person;
import org.hibernate.Session;

public class RunHiberExample {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Person person1 = new Person( "James", "Bond", "007@jamesbond.com", new java.util.Date() );
        Person person2 = new Person( "Forest", "Gump", "forestgump@jamesbond.com", new java.util.Date() );

        session.beginTransaction();

        session.save( person1 );
        session.save( person2 );

        session.getTransaction().commit();

        Person p1 = (Person) session.get( Person.class, 1L );
        Person p2 = (Person) session.get( Person.class, 2L );

        System.out.println(p1);
        System.out.println(p2);

        session.beginTransaction();

        p1.setEmail("test_user1@test.com");
        p2.setEmail("test_user2@test.com");

        session.update(p1);
        session.update(p2);

        session.delete(session.get( Person.class, 2L ));

        session.getTransaction().commit();

         p1 = (Person) session.get( Person.class, 1L );
         p2 = (Person) session.get( Person.class, 2L );

        System.out.println(p1);
        System.out.println(p2);

    }
}
