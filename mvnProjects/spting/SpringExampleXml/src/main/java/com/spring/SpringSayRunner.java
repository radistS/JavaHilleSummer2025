package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringSayRunner {
    public static void main(String[] args) throws InterruptedException {
        ApplicationContext context =
            new FileSystemXmlApplicationContext("mvnProjects/spting/SpringExampleXml/src/resources/spring-bean.xml");
        Say obj1 = context.getBean("say", Say.class);
        obj1.say();

        System.exit(2);
    }
}
