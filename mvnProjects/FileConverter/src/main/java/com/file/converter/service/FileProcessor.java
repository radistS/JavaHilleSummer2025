package com.file.converter.service;

import com.file.converter.constats.Extension;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface FileProcessor {

    String readFromFile(String filePath) throws IOException;

    void writeToFile(String folder, String fileName, String newExtension,  String content) throws IOException;

    boolean isProcessedFile(Path filePath);

    void deleteFile(String filePath) throws IOException;

    void folderFileChecker(String folderPath, List<Extension> extensions, String outputFolderPath) throws IOException;

}
