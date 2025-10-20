package com.app.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorObject {
    private String message;
    private String code;
    private String field;

}
