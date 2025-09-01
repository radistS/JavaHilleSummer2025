package com.pars.csv;

import com.opencsv.bean.CsvToBeanBuilder;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class StudentParser {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "/Users/oleksandrstepurko/IdeaProjects/JavaHilleSummer2025-https/mvnProjects/pars/src/main/resources/student.csv";

        List<Student> lines = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(Student.class)
                .withSeparator(',')
                .build()
                .parse();

        List<Address> addresses = new CsvToBeanBuilder(new FileReader(fileName))
            .withType(Address.class)
            .withSeparator(',')
            .build()
            .parse();

        for (int i = 0; i < lines.size(); i++) {
            Student student = lines.get(i);
            student.setAddress(addresses.get(i));
        }

        lines.forEach(System.out::println);
    }
}
