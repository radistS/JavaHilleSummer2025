package com.hilllel.cw_07.task;

/*
Валідація email-адреси
boolean isValidEmail(String email);
Перевірка має відбуватись за допомогою регулярного виразу.

^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$
 */
public class EmailValidator {

    public static void main(String[] args) {

        System.out.println(isValid("a@mail.com"));
        System.out.println(isValid("a@mailcom"));
        System.out.println(isValid("a@mailcom."));

    }

    public static boolean isValid(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }

        if (email.lastIndexOf("@") == email.length() - 1) {
            return false;
        }

        if (email.lastIndexOf(".") == email.length() - 1) {
            return false;
        }

        if (email.indexOf("@") != email.lastIndexOf("@")){
            return false;
        }

        String domain = email.substring(email.lastIndexOf("@") + 1);

        return domain.contains(".");

    }

}
