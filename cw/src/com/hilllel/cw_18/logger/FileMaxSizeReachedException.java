package com.hilllel.cw_18.logger;

public class FileMaxSizeReachedException extends RuntimeException{

    public FileMaxSizeReachedException(String message) {
        super(message);
    }
}
