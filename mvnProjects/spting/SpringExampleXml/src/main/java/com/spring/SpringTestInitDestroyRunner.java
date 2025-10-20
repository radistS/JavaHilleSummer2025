package com.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SpringTestInitDestroyRunner {
    public static void main(String[] args) {
        ApplicationContext context =
            new FileSystemXmlApplicationContext("mvnProjects/spting/SpringExampleXml/src/resources/spring-bean.xml");
        for (int i = 0; i < 10; i++) {
            context.getBean("test", Test.class);
        }
    }
}
