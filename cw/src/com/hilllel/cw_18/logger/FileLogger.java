package com.hilllel.cw_18.logger;

public class FileLogger {

    private FileLoggerConfiguration config;

    public FileLogger(FileLoggerConfiguration config) {
        this.config = config;
    }

    void log(Level level, String message){
        // 1 - create log file using path, if not exist

        // 2 - check level
        // if level.info -> info, debug
        // if level.debug -> debug

        // 3 - generate log line by pattern: time level message
        String log = String.format("%s %s Message: %s ", System.currentTimeMillis(), level, message); // time, level, message
        String debug = String.format(config.getLogFormat(), System.currentTimeMillis(), level, message); // time, level, message

        // 4 - check size > more then max size -> FileMaxSizeReachedException

        // 5 -  write to file + show in console
    }
}
