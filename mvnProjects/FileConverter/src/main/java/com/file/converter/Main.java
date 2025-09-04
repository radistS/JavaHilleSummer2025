package com.file.converter;

import com.file.converter.constats.Extension;
import com.file.converter.service.FileProcessor;
import com.file.converter.service.impl.FileProcessorImpl;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("File Converter v 0.0.1");

        FileProcessor fileProcessor = new FileProcessorImpl();
        fileProcessor.folderFileChecker(
            "/Users/oleksandrstepurko/test",
            Arrays.stream(Extension.values()).toList(),
            "/Users/oleksandrstepurko/test/output"
            );

    }
}
