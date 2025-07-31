package com.mvn.first;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        Book book = new Book();
        book.setId(1);
        book.setTitle("Star Wars");
        book.setAuthor("Star Wars");
        book.setIsbn("isbdn");
        System.out.println(book);
    }
}
