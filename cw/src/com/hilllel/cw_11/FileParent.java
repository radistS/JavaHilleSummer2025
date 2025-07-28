package com.hilllel.cw_11;

import java.io.File;

public class FileParent {

    public static void main(String[] args) {
        File dir = new File("/Users/oleksandrstepurko/IdeaProjects/JavaHilleSummer2025-https/files");
        while (dir != null) {
            System.out.println(dir.getParent());
            dir = dir.getParentFile();
        }
    }

}
