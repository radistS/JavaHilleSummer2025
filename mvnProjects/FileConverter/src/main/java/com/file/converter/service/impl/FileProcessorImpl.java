package com.file.converter.service.impl;

import com.file.converter.constats.Extension;
import com.file.converter.service.FileMapper;
import com.file.converter.service.FileProcessor;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lombok.SneakyThrows;

public class FileProcessorImpl implements FileProcessor {

    @Override
    public String readFromFile(String filePath) throws IOException {
        return Files.readString(Path.of(filePath));
    }

    @Override
    public void writeToFile(String folder, String fileName, String newExtension, String content)
        throws IOException {
        if (!Paths.get(folder).toFile().exists()) {
            Paths.get(folder).toFile().mkdir();
        }
        String fileOutput = folder.concat(File.separator)
            .concat(changeExtension(fileName, newExtension));
        Files.writeString(Path.of(fileOutput), content);
    }

    @Override
    public boolean isProcessedFile(Path filePath) {
        if (Files.exists(filePath) && Files.isRegularFile(filePath)) {
            String fileName = filePath.getFileName().toString();
            int extensionIndex = fileName.lastIndexOf(".");
            String extension = fileName.substring(extensionIndex + 1);
            return Arrays.stream(Extension.values()).toList()
                .contains(Extension.valueOf(extension.toUpperCase()));
        }
        return false;
    }

    private String changeExtension(String fileName, String newExtension) {
        int dotIndex = fileName.lastIndexOf('.');

        String baseName = (dotIndex == -1)
            ? fileName                  // no extension
            : fileName.substring(0, dotIndex);

        return baseName + "." + newExtension;
    }

    @Override
    public void deleteFile(String filePath) throws IOException {
        Files.delete(Path.of(filePath));
    }

    @SneakyThrows
    @Override
    public void folderFileChecker(String folderPath, List<Extension> extensions,
        String outputFolderPath) throws IOException {

        WatchService watchService
            = FileSystems.getDefault().newWatchService();

        Path path = Paths.get(folderPath);

        path.register(
            watchService,
            StandardWatchEventKinds.ENTRY_CREATE);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                Path p = (Path) event.context();
                String filePath = folderPath.concat(File.separator).concat(p.toString());
                System.out.println(Path.of(filePath));
                if (isProcessedFile(Paths.get(filePath))) {
                    System.out.printf("File path: %s\n", filePath);
                    FileMapper fileMapper = new FileMapperYaml();
                    String content = fileMapper.convertFile(readFromFile(filePath));

                    writeToFile(outputFolderPath, p.toString(), "yaml", content);
                }
            }
            key.reset();
        }

    }

}
