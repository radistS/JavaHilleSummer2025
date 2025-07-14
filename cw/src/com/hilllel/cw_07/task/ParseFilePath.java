package com.hilllel.cw_07.task;

import java.io.File;
import javax.swing.plaf.synth.SynthOptionPaneUI;

/*
Виділити ім'я файлу та розширення
FileInfo parseFilePath(String path);
"/home/user/docs/report.pdf" → name: "report", ext: "pdf"
 */
public class ParseFilePath {

    public static void main(String[] args) {
        System.out.println(parseFilePath("/home/user/docs/report.pdf"));    }

    public static FileInfo parseFilePath(String filePath) {
        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1);
        String[] file = fileName.split("\\.");
        return new FileInfo(file[0], file[1]);

    }
}

class FileInfo {
    private String name;
    private String ext;

    public FileInfo(String name, String ext) {
        this.name = name;
        this.ext = ext;
    }

    @Override
    public String toString() {
        return "name:" + name  + ", ext:" + ext ;
    }
}
