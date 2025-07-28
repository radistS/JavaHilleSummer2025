package com.hilllel.cw_11.folders;


import java.io.File;
import java.io.IOException;

public class MakeDir {

    public static void main(String[] args) throws IOException {
        String baseName = "/Users/oleksandrstepurko/IdeaProjects/JavaHilleSummer2025-https/files"; // base path

        String dirName = baseName + File.separator + "dir1"; // dir path
        String createFile = dirName + "/test.txt"; // file path
        String dirName1 = baseName + "/dir1/dir2/dir3"; // dir paths
        String dirName2 =dirName1 + "/dir4"; // dir paths

        System.out.println("create dir : " + dirName);
        File dir = new File(dirName);
        System.out.println(dir.mkdir()); // one next folder
        File dir1 = new File(dirName1);
        System.out.println(dir1.mkdirs()); // folder hierarchy
        File dir2 = new File(dirName2);
        System.out.println(dir2.mkdirs()); // one folder

        System.out.println("check is dir exist");
        System.out.println(dir1.exists());

        System.out.println("is file : " + dir1.isFile());
        System.out.println("is directory : " + dir1.isDirectory());


        File file = new File(createFile);

        // create file
        if (!file.exists()) // check if exist
            System.out.println(file.createNewFile()); // create file
//
        // delete file
//        if (file.exists()) // check if exist
//            System.out.println(file.delete()); // delete file

        System.out.println("dir exist: " + dir2.exists()); // check if path exist
        System.out.println("isDirectory: " + dir2.isDirectory()); // if true directory, else file
        System.out.println("isHidden: " + dir2.isHidden()); // is hidden or not
        System.out.println("isFile: " + dir2.isFile()); // if true file, else directory
        System.out.println("canRead : " + dir2.canRead()); // available read
        System.out.println("canWrite : " + dir2.canWrite()); // available write
        System.out.println("canExecute : " + dir2.canExecute()); // available execute



        System.out.println("dir name : " + dir.getName());
        System.out.println("get Parent:" + dir.getParent());
        System.out.println("list files :" + dir.listFiles().length);
        System.out.println("parent list files :" + dir.getParentFile().length());

        System.out.println("-------");

        File parent = dir.getParentFile();
        System.out.println("dir name : " + parent.getName());
        System.out.println("get Parent:" + parent.getParent());
        System.out.println("list files :" + parent.listFiles().length);
        System.out.println("parent list files :" + dir.getParentFile().length());

        for (File f : parent.listFiles()){
            String name = f.getName();
            if (f.isHidden()){
                name = name + " Hidden";
            }

            System.out.println("file name : " + name);
        }

    }
}
