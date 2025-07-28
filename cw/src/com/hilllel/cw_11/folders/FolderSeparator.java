package com.hilllel.cw_11.folders;

import java.io.File;

public class FolderSeparator {
    public static void main(String[] args) {
        String folder = "baseFolder";
        // dir1/dir2/ -linux
        // dir1\dir2\

        folder = folder.concat(File.separator).concat("1").concat(File.separator).concat("1").concat(File.separator).concat("1");
//        folder = folder.concat("\\").concat("1").concat("/").concat("1").concat(File.separator).concat("1");

        System.out.println(folder);
    }
}
