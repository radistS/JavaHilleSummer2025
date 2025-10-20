package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.awt.*;

public class SpringTestRunner {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Start main...");
        ApplicationContext context =
                new FileSystemXmlApplicationContext("mvnProjects/spting/SpringExampleXml/src/resources/spring-bean.xml");

        System.out.println("Get bean...");
        Thread.sleep(5000);
        Test obj1 = (Test) context.getBean("test");

        Thread.sleep(5000);
        Test obj2 = context.getBean("test", Test.class);
        Thread.sleep(5000);
        Test obj3 = (Test) context.getBean("test1");


        System.out.println(obj1 + " hash=" + obj1.hashCode());
        System.out.println(obj2 + " hash=" + obj2.hashCode());
        System.out.println(obj3);

        obj1.setName("Oleksandr_new");

        System.out.println(obj1 + " hash=" + obj1.hashCode());
        System.out.println(obj2 + " hash=" + obj2.hashCode());
        System.out.println(obj3);

    }

}
