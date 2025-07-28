package com.hilllel.cw_10;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestHM {
    public static void main(String[] args) {
        Map<Fruit, Integer> shop = new HashMap<>();
        Fruit banana = new Fruit("Banana");
        shop.put(banana, 100);
        System.out.println(shop.get(banana));
        banana.name = "mango";
        System.out.println(shop.get(banana));
    }
}


class Fruit{
    String name;
    int price;

    public Fruit(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Fruit(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return price == fruit.price && Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
