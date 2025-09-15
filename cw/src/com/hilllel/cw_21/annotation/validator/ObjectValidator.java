package com.hilllel.cw_21.annotation.validator;


import com.hilllel.cw_21.annotation.validator.anot.Email;
import com.hilllel.cw_21.annotation.validator.anot.Min;
import com.hilllel.cw_21.annotation.validator.anot.NotNull;
import com.hilllel.cw_21.annotation.validator.anot.Size;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ObjectValidator {

    private static final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public static void validate(Object obj) throws IllegalAccessException {
        Class<?> clazz = obj.getClass();

        // Проходим по всем полям объекта
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true); // На случай, если поле приватное

            // Проверяем, есть ли аннотация @NotNull на поле
            if (field.isAnnotationPresent(NotNull.class)) {
                Object value = field.get(obj);  // Получаем значение поля
                NotNull notNull = field.getAnnotation(NotNull.class);  // Получаем аннотацию

                // Если поле null, выводим сообщение об ошибке
                if (value == null) {
                    System.out.println("Validation failed: " + notNull.message() + " (Field: " + field.getName() + ")");
                }
            }

            // Проверка на минимальное значение
            if (field.isAnnotationPresent(Min.class)) {
                Min min = field.getAnnotation(Min.class);
                if (field.getType() == int.class || field.getType() == Integer.class) {
                    int fieldValue = field.getInt(obj);
                    if (fieldValue < min.value()) {
                        System.out.println("Validation failed: " + min.message() + " (Field: " + field.getName() + ", Min: " + min.value() + ")");
                    }
                }
            }

            // Проверка на @Size
            if (field.isAnnotationPresent(Size.class)) {
                Size size = field.getAnnotation(Size.class);
                Object value = field.get(obj);

                if (value instanceof String) {
                    int length = ((String) value).length();
                    if (length < size.min() || length > size.max()) {
                        System.out.println("Validation failed: " + size.message() + " (Field: " + field.getName() +
                            ", Length: " + length + ", Min: " + size.min() + ", Max: " + size.max() + ")");
                    }
                } else if (value instanceof Collection) {
                    int sizeValue = ((Collection<?>) value).size();
                    if (sizeValue < size.min() || sizeValue > size.max()) {
                        System.out.println("Validation failed: " + size.message() + " (Field: " + field.getName() +
                            ", Size: " + sizeValue + ", Min: " + size.min() + ", Max: " + size.max() + ")");
                    }
                }
            }

            // Проверка на @Email
            if (field.isAnnotationPresent(Email.class)) {
                Object value = field.get(obj);
                if (value instanceof String) {
                    String email = (String) value;
                    Email emailAnnotation = field.getAnnotation(Email.class);
                    if (!EMAIL_PATTERN.matcher(email).matches()) {
                        System.out.println("Validation failed: " + emailAnnotation.message() + " (Field: " + field.getName() + ")");
                    }
                }
            }
        }
    }

    public static User validateAndCreate(String name, String email, int age) throws IllegalAccessException {
        User obj = new User(name, email, age);
        Class<?> clazz = obj.getClass();

        List<String> errors = new ArrayList();
        // Проходим по всем полям объекта
        for (Field field : clazz.getDeclaredFields()) {
            field.setAccessible(true); // На случай, если поле приватное



            // Проверяем, есть ли аннотация @NotNull на поле
            if (field.isAnnotationPresent(NotNull.class)) {
                Object value = field.get(obj);  // Получаем значение поля
                NotNull notNull = field.getAnnotation(NotNull.class);  // Получаем аннотацию

                // Если поле null, выводим сообщение об ошибке
                if (value == null) {
                    errors.add("Validation failed: " + notNull.message() + " (Field: " + field.getName() + ")");
                }
            }

            // Проверка на минимальное значение
            if (field.isAnnotationPresent(Min.class)) {
                Min min = field.getAnnotation(Min.class);
                if (field.getType() == int.class || field.getType() == Integer.class) {
                    int fieldValue = field.getInt(obj);
                    if (fieldValue < min.value()) {
                        errors.add("Validation failed: " + min.message() + " (Field: " + field.getName() + ", Min: " + min.value() + ")");
                    }
                }
            }

            // Проверка на @Size
            if (field.isAnnotationPresent(Size.class)) {
                Size size = field.getAnnotation(Size.class);
                Object value = field.get(obj);

                if (value instanceof String) {
                    int length = ((String) value).length();
                    if (length < size.min() || length > size.max()) {
                        errors.add("Validation failed: " + size.message() + " (Field: " + field.getName() +
                            ", Length: " + length + ", Min: " + size.min() + ", Max: " + size.max() + ")");
                    }
                } else if (value instanceof Collection) {
                    int sizeValue = ((Collection<?>) value).size();
                    if (sizeValue < size.min() || sizeValue > size.max()) {
                        errors.add("Validation failed: " + size.message() + " (Field: " + field.getName() +
                            ", Size: " + sizeValue + ", Min: " + size.min() + ", Max: " + size.max() + ")");
                    }
                }
            }

            // Проверка на @Email
            if (field.isAnnotationPresent(Email.class)) {
                Object value = field.get(obj);
                if (value instanceof String) {
                    String mail = (String) value;
                    Email emailAnnotation = field.getAnnotation(Email.class);
                    if (!EMAIL_PATTERN.matcher(mail).matches()) {
                        errors.add("Validation failed: " + emailAnnotation.message() + " (Field: " + field.getName() + ")");
                    }
                }
            }

        }

        if (!errors.isEmpty()) {
            throw new UserCreationException(errors.stream().collect(Collectors.joining(System.lineSeparator(), System.lineSeparator(), System.lineSeparator())));
        }
        return obj;
    }

}
