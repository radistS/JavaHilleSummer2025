package com.hilllel.cw_18.file;

import java.nio.file.FileSystems;
import java.nio.file.Path;

public class CurrentDirectory {
    public static void main(String[] args) {
        String currentWorkingDirectory;
        System.out.println("--------------");
        Path path = FileSystems.getDefault().getPath("").toAbsolutePath();
        currentWorkingDirectory=path.toString();
        System.out.println("Current working directory is : "+currentWorkingDirectory);
        System.out.println("--------------");
    }
}

