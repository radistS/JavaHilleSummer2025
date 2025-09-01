package com.pars.csv;

import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

public class CsvParser_ {

    public static void main(String[] args) throws FileNotFoundException {
        String fileName = "/Users/oleksandrstepurko/IdeaProjects/JavaHilleSummer2025-https/mvnProjects/pars/src/main/resources/username_1.csv";

        List<UEmail_> beans = new CsvToBeanBuilder(new FileReader(fileName))
                .withType(UEmail_.class)
                .withSeparator(',')
                .build()
                .parse();

        long start = System.currentTimeMillis();

        long finish = System.currentTimeMillis();

        long duration = finish - start;

        beans.forEach(System.out::println);
    }
}
