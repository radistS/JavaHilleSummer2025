package com.hilllel.cw_11.io.FileStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class FileOutputStreamm {
    public static void main(String[] args) throws IOException {
        OutputStream outputStream =
                new FileOutputStream("/Users/oleksandrstepurko/IdeaProjects/JavaHilleSummer2025-https/cw/src/com/hilllel/cw_11/io/FileStream/input.txt",
                    true);

        outputStream.write("override findFileDuplicate.md from java app\n".getBytes(StandardCharsets.UTF_8));
    }
}
