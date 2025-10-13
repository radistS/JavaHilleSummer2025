package com.home.hibernate.entity;

import javax.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Formula;


@Entity // This tells Hibernate to make a table out of this class
@Table(name = "student") // table name in db
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column( name = "first_name")
    private String firstName;
    @Column( name = "last_name")
    private String lastName;
    private String email;
    @Transient
    private String fullName;

    @Formula("concat(first_name, ' ', last_name)")
    private String name;

    @Formula("(select count(h.id) from homework h where h.student_id = id)")
    private int hwCount;

    @OneToMany(mappedBy = "student", fetch =  FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
    private Set<Homework> homeworks = new HashSet<>();

    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public void addHomework(final Homework homework) {
        homeworks.add(homework);
    }

    public void removeHomework(final Homework homework) {
        homeworks.remove(homework);
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }

}
