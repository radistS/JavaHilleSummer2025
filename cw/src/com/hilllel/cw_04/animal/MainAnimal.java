package com.hilllel.cw_04.animal;

public class MainAnimal {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.voice();

        Dog dog = new Dog();
        dog.voice();

        Cat cat = new Cat("1");
        System.out.println(cat.toString());
        cat.voice();
        cat.setAge("4");
        cat.setName("Barsik");



        System.out.println(cat.toString());
//        System.out.println(cat.getClass().getName());
//        System.out.println(cat.getClass().getSuperclass().getName());
//        System.out.println(cat.getClass().getSuperclass().getSuperclass().getName());
//        System.out.println(cat.getClass().getSimpleName());
//        System.out.println(cat.getClass().getConstructors().length);
//
//        for (Constructor constr :cat.getClass().getConstructors()) {
//            System.out.println(constr.getParameterCount());
//        }
//
//        Cat cat1 = new Cat("Barsik");
//        Cat cat2 = new Cat("Barsik");
//        Cat cat3 = cat1;
//        System.out.println(cat1.equals(cat2));
//        System.out.println(cat1.equals(cat3));
//
//        System.out.println(cat1.hashCode());
//        System.out.println(cat2.hashCode());
//        System.out.println(cat3.hashCode());
    }
}
