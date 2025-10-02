package com.hilllel.cw_24.gof.factory;

interface Product {

    void use();
}

class ConcreteProductA implements Product {

    public void use() {
        System.out.println("Using product A");
    }
}

class ConcreteProductB implements Product {

    public void use() {
        System.out.println("Using product B");
    }
}

abstract class Creator {

    protected abstract Product createProduct();

    public void process() {
        Product p = createProduct();
        p.use();
    }
}

class CreatorA extends Creator {

    protected Product createProduct() {
        return new ConcreteProductA();
    }
}

class CreatorB extends Creator {

    protected Product createProduct() {
        return new ConcreteProductB();
    }
}

public class Factory {

    public static void main(String[] args) {
        Creator creator = new CreatorA();
        creator.process(); // Using product A

        creator = new CreatorB();
        creator.process(); // Using product B
    }
}
