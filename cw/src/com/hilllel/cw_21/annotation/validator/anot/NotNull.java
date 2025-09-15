package com.hilllel.cw_21.annotation.validator.anot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  // Аннотация доступна в рантайме
@Target(ElementType.FIELD)           // Аннотация может быть применена только к полям
public @interface NotNull {
    String message() default "Field cannot be null";
}
