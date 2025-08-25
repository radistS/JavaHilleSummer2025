package com.hilllel.cw_16.funcInterface;

import java.util.function.Consumer;
import java.util.function.Supplier;
/*
    Представляє постачальника (постачальника значення), який не приймає жодних аргументів і повертає значення типу T.
 */
public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Integer> randomIntegerSupplier = () -> (int) (Math.random() * 100); // return yes -> get()
        System.out.println("Random value: " + randomIntegerSupplier.get());

        randomIntegerSupplier = () -> 12;
        System.out.println("Random value: " + randomIntegerSupplier.get());

        Consumer<String> toUC = s -> System.out.println(s.toUpperCase()); // return no - accept()

        toUC.accept(Sup.randomStringSupplier().get());
    }

    static class Sup{

        static Supplier<Integer> randomIntegerSupplier(){
            return ()-> (int)(Math.random() * 100);
        };

        static Supplier<String> randomStringSupplier(){
            return ()->"Hello World";
        }

    }

}
