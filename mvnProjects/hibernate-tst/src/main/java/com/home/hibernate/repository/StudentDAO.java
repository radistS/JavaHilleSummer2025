package com.home.hibernate.repository;


import com.home.hibernate.util.HibernateUtil;
import com.home.hibernate.entity.Homework;
import com.home.hibernate.entity.Student;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class StudentDAO implements GenericDAO<Student, Long> {

    @Override
    public void save(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        student.getHomeworks().forEach(hw -> {
                hw.setStudent(student);
                session.save(hw);
        });

        transaction.commit();
        session.close();
    }

    @Override
    public Student findById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Student student = (Student) session.get(Student.class, id);
        student.setFullName(student.getFullName());
        session.close();
        return student;
    }

    public Homework hwFindById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Homework homework = (Homework) session.get(Homework.class, id);
        session.close();
        return homework;
    }

    @Override
    public Student findByEmail(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createQuery("from Student where email = :email");
        query.setString("email", email);
        Student result = (Student) query.uniqueResult();
        return result;
    }

    public Student findByEmailNative(String email) {
        Session session = HibernateUtil.getSessionFactory().openSession();

        Query query = session.createSQLQuery("select * from student where email = :email");
        query.setString("email", email);
        Student result = (Student) query.uniqueResult();
        return result;
    }

    @Override
    public List<Student> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Student> students = session.createQuery("FROM Student").list(); // --> HQL, select * from student (SQL)
        session.close();
        return students;
    }

    @Override
    public Student update(Student student) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.merge(student);
        session.getTransaction().commit();
        session.close();
        return student;
    }

    @Override
    public boolean deleteById(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Student student = (Student) session.get(Student.class, id);
        session.delete(student);
        session.getTransaction().commit();
        session.close();
        return true;
    }

}
