package com.hilllel.cw_11;

import java.io.File;
import java.io.IOException;

public class FilesDir {
    public static void main(String[] args) throws IOException, InterruptedException {
        String nameDir1 = "hillelClassworks/src.com.hillel/lesson_19/file/example";
        String nameDir2 = nameDir1 + "/test_in/test_inn";
        String nameDir3 = nameDir1 + "/test_in";
        String nameDir4 = nameDir1 + "/test_in23";

        File dir = new File(nameDir2);
        File dir1 = new File(nameDir3);
        File dir2 = new File(nameDir4);

        System.out.println(dir.mkdir());  // false
        System.out.println(dir1.mkdir()); // true
        System.out.println(dir.mkdirs()); // true
        System.out.println(dir2.mkdirs()); // true

        System.out.println("Name : " + dir.getName());
        System.out.println("isDir: " + dir.isDirectory());
        System.out.println("ifFile: " + dir.isFile());
        System.out.println("parent : " + dir.getParent());
        System.out.println(dir.getAbsolutePath());
        System.out.println(dir.canRead());
        System.out.println(dir.canWrite());
        System.out.println(dir.setReadable(false));
        System.out.println(dir.setWritable(false));
        System.out.println(dir.canRead());
        System.out.println(dir.canWrite());
////
//        System.out.println(dir.lastModified());
//        dir.setWritable(true);
//        dir.setWritable(true);
//        Thread.sleep(1000);
//        System.out.println(dir.lastModified());
//
        String filename1 = "example1.txt";
        String filename2 = "example2.txt";
        String filename3 = "example3.txt";

        File file1 = new File(nameDir1, filename1);
        File file2 = new File(nameDir2, filename2);
        File file3 = new File(nameDir3, filename3);



        System.out.println(file1.createNewFile());
        System.out.println(file2.createNewFile());
        System.out.println(file3.createNewFile());
//
        System.out.println(file1.exists());
        System.out.println(file2.exists());
////
        System.out.println(file1.lastModified());
        System.out.println(file2.lastModified());
//
        System.out.println(file1.isHidden());
        System.out.println(file1.isAbsolute());
        System.out.println(file1.isDirectory());
        System.out.println(file1.isHidden());

//        System.out.printf("_____________");
//
//        try (FileWriter fw = new FileWriter("/Users/stepurkoolksandr/javaWinter2020/lessons/src/com/hillel/lesson_17/test/example1.txt")) {
//            String str = "Hello world ...";
//               for (char c : str.toCharArray()){
//                   fw.write(c);
//               }
//
//            }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
    }
}

