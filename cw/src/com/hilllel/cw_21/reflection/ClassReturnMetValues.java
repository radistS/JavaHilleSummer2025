package com.hilllel.cw_21.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Arrays;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

public class ClassReturnMetValues {
    public static void main(String[] args) throws NoSuchMethodException {
        Class boo = new Boo().getClass();

        Method method = boo.getMethod("print");

        System.out.println(method.getReturnType());

        Annotation[] annotations = method.getAnnotations();
        System.out.println(Arrays.toString(annotations));
        System.out.println("-------------");
        annotations = boo.getAnnotations();
        System.out.println(Arrays.toString(annotations));
        System.out.println("-------------");
        Class<?>[] exceptionTypes = method.getExceptionTypes();
        System.out.println(Arrays.toString(exceptionTypes));
    }
}

@Data
@Builder
@EqualsAndHashCode
@Deprecated
@TestSource
class Boo {
    @Deprecated
    public String print() throws SQLException, ArithmeticException {
        return "null";
    }
}
