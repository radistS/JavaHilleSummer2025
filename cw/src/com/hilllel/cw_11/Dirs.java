package com.hilllel.cw_11;

import java.io.File;

public class Dirs {
    public static void main(String[] args) {
        String baseDir = "/Users/oleksandrstepurko/IdeaProjects/JavaHilleSummer2025-https";

        File dir = new File(baseDir);
        print(dir);
    }

    private static void print(File dir) {
        for (File file : dir.listFiles()) {
            if (file.isDirectory()) {
                System.out.println("dir : " + file.getName());
                print(file);
            } else {
                System.out.println("file : " + file.getName());
            }
        }
    }

}
