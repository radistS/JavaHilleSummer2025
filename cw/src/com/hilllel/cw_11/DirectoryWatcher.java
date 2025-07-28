package com.hilllel.cw_11;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DirectoryWatcher {
    public static void main(String[] args) throws IOException, InterruptedException {
        WatchService watchService
            = FileSystems.getDefault().newWatchService();

        Path path = Paths.get("/Users/oleksandrstepurko/IdeaProjects/JavaHilleSummer2025-https/files");

        path.register(
            watchService,
            StandardWatchEventKinds.ENTRY_CREATE,
            StandardWatchEventKinds.ENTRY_DELETE,
            StandardWatchEventKinds.ENTRY_MODIFY);

        WatchKey key;
        while ((key = watchService.take()) != null) {
            for (WatchEvent<?> event : key.pollEvents()) {
                System.out.println( timestamp() +
                    " >>> Event kind:" + event.kind()
                        + ". File affected: " + event.context() + ".");
            }
            key.reset();
        }
    }

    private static String timestamp(){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ssSSS");
        return now.format(formatter);
    }
}
