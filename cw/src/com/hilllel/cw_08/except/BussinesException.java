package com.hilllel.cw_08.except;

import java.io.IOException;

public class BussinesException extends IOException {
    public BussinesException(String message) {
        super(message);
    }
}
