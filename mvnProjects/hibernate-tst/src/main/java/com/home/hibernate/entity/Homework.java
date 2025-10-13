package com.home.hibernate.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "homework")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Homework {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    @ToString.Exclude
    private Student student;


    private String description;
    private String subject;
    private LocalDate deadline;
    private int mark;

    public Homework(String description, LocalDate deadline, int mark) {
        this.description = description;
        this.deadline = deadline;
        this.mark = mark;
    }
}
