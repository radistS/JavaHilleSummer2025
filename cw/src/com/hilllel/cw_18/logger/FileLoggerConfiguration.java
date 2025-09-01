package com.hilllel.cw_18.logger;

public class FileLoggerConfiguration {
    private String path; // ../result.log
    private Level level;
    private Integer maxFileSize; // in byte
    private String logFormat;

    public FileLoggerConfiguration(String path, Level level, Integer maxFileSize,
            String logFormat) {
        this.path = path;
        this.level = level;
        this.maxFileSize = maxFileSize;
        this.logFormat = logFormat;
    }

    public String getPath() {
        return path;
    }

    public Level getLevel() {
        return level;
    }

    public Integer getMaxFileSize() {
        return maxFileSize;
    }

    public String getLogFormat() {
        return logFormat;
    }
}
