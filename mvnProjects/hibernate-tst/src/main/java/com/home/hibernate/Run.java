package com.home.hibernate;

import com.home.hibernate.util.HibernateUtil;
import org.hibernate.Session;

public class Run {
    public static void main(String[] args) {
        HibernateUtil.getSessionFactory().openSession();
    }
}
