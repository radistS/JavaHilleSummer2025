package com.hilllel.cw_11.file.walk;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileWalk {
    public static void main(String[] args) {
        Path start = Paths.get("/Users/oleksandrstepurko/IdeaProjects/JavaHilleSummer2025-https/cw/src/com/hilllel/cw_11");

        try {
            Files.walk(start)
                .forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
