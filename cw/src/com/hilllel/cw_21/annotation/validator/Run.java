package com.hilllel.cw_21.annotation.validator;

public class Run {
    public static void main(String[] args) throws IllegalAccessException {
        // Создаем объект с некорректными данными
        User user = new User("alexx", "mail.mail@mail.com", 18);

        // Проверяем объект
        ObjectValidator.validate(user);

        User us = ObjectValidator.validateAndCreate(null, null, 10);
//        User us = ObjectValidator.validateAndCreate("Oleksandr", "mail@mail.com", 20);

        System.out.println(us);
    }

}
