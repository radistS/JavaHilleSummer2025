package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringHelloWorldRunner {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context =
            new FileSystemXmlApplicationContext("mvnProjects/spting/SpringExampleXml/src/resources/spring-bean.xml");

        Teacher t = (Teacher) context.getBean("teacher");
        Student s = (Student) context.getBean("student");

        System.out.println(t);
        System.out.println(s);

        SpringHelloWorld springHelloWorld = (SpringHelloWorld) context.getBean("springHelloWorld");
        SpringHelloWorld springHelloWorld1 = (SpringHelloWorld) context.getBean("helloWorld");


        System.out.println(springHelloWorld.getStudent().toString());
        System.out.println(springHelloWorld1);

        System.out.println(springHelloWorld.getUser().toString());
        System.out.println(springHelloWorld1.getStudent().toString());

        springHelloWorld.getHelloMessage();
    }
}
