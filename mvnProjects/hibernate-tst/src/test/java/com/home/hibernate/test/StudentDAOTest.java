package com.home.hibernate.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.home.hibernate.util.HibernateUtil;
import com.home.hibernate.repository.StudentDAO;
import com.home.hibernate.entity.Homework;
import com.home.hibernate.entity.Student;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class StudentDAOTest {

    private static StudentDAO studentDAO;

    @BeforeAll
    public static void setUpBeforeClass() {
        studentDAO = new StudentDAO();
    }

    @AfterEach
    public void cleanDB() {
        SessionFactory hu = HibernateUtil.getSessionFactory();
        Session session = hu.getCurrentSession();
        session.beginTransaction();
        session.createSQLQuery("SET FOREIGN_KEY_CHECKS = 0").executeUpdate(); // disable foreign key checks
        session.createSQLQuery("TRUNCATE TABLE student").executeUpdate();
        session.createSQLQuery("TRUNCATE TABLE homework").executeUpdate();
        session.createSQLQuery("SET FOREIGN_KEY_CHECKS = 1").executeUpdate(); // enable foreign key checks

        session.getTransaction().commit();
    }

    @AfterAll
    public static void tearDown() {
    }

    @Test
    void save() {
        Student student = getStudent("Alex");
        studentDAO.save(student);
        assertEquals(1, studentDAO.findAll().size());
    }

    @Test
    void findById() {
        Student student = getStudent("Alex");
        studentDAO.save(student);
        Student result = studentDAO.findById(student.getId());
        assertEquals("Alex", result.getFirstName());
        assertEquals("Alex Johnson", result.getFullName());
        assertEquals(student.getId(), result.getId());
    }

    @Test
    void findByEmail() {
        Student student = getStudent("Alex");
        studentDAO.save(student);
        Student result = studentDAO.findByEmail(student.getEmail());
        assertEquals("Alex", result.getFirstName());
    }

    @Test
    void findByEmailNative() {
        Student student = getStudent("Alex");
        studentDAO.save(student);
        Student result = studentDAO.findByEmailNative(student.getEmail());
        assertEquals("Alex", result.getFirstName());
    }


    @Test
    void findAll() {
        Student student1 = getStudent("Alex");
        Student student2 = getStudent("Oleksandr");

        studentDAO.save(student1);
        studentDAO.save(student2);
        List<Student> st = studentDAO.findAll();

        assertEquals(2, st.size());
        st.forEach(s -> {
            assertTrue(List.of("Alex", "Oleksandr").contains(s.getFirstName()));
        });
    }

    @Test
    void update() {
        Student student = getStudent("Alex");
        studentDAO.save(student);
        student.setFirstName("Tom");
        studentDAO.update(student);
        Student result = studentDAO.findById(student.getId());
        assertEquals("Tom", result.getFirstName());
    }

    @Test
    void deleteById() {
        Student student = getStudent("Alex");
        studentDAO.save(student);
        assertEquals(1, studentDAO.findAll().size());
        studentDAO.deleteById(1L);
        assertEquals(0, studentDAO.findAll().size());
    }

    @Test
    void testOneToManyMapping() {
        Student student = getStudent("Alex");
        student.setHomeworks(Set.of(getHomework("hw1"), getHomework("hw2")));
        studentDAO.save(student);
        Student studentDB = studentDAO.findById(student.getId());
        assertEquals(2, studentDB.getHomeworks().size());
    }

    @Test
    void getHomeworksById(){
        Student student = getStudent("Alex");
        student.setHomeworks(Set.of(getHomework("hw1"), getHomework("hw2")));
        studentDAO.save(student);

        Homework hw = studentDAO.hwFindById(student.getId());
        assertEquals(2, hw.getStudent().getHomeworks().size());
    }


    private Student getStudent(String name) {
        return new Student(name, "Johnson", "david@gmail.com");
    }

    private Homework getHomework(String description) {
        return new Homework(description, LocalDate.now(), 5);
    }
}
