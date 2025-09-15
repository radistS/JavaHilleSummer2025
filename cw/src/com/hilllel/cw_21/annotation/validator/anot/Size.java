package com.hilllel.cw_21.annotation.validator.anot;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  // Аннотация доступна в рантайме
@Target(ElementType.FIELD)           // Аннотация применяется к полям
public @interface Size {
    int min() default 0;             // Минимальная длина (по умолчанию 0)
    int max() default Integer.MAX_VALUE;  // Максимальная длина (по умолчанию максимально возможное значение)
    String message() default "Size is not within the allowed range";
}
