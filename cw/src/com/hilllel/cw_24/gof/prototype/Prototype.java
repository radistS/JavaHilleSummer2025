package com.hilllel.cw_24.gof.prototype;

import java.util.*;

interface DeepCopyable<T> { T deepCopy(); }

class Style implements DeepCopyable<Style> {
    String stroke, fill;
    Style(String stroke, String fill) { this.stroke = stroke; this.fill = fill; }
    public Style deepCopy() { return new Style(stroke, fill); }
}

abstract class Shape implements DeepCopyable<Shape> {
    int x, y;
    Style style;
    Shape(int x, int y, Style s) { this.x = x; this.y = y; this.style = s; }
}

class Circle extends Shape {
    int r;
    Circle(int x, int y, int r, Style s) { super(x, y, s); this.r = r; }
    public Circle deepCopy() { return new Circle(x, y, r, style.deepCopy()); }
    public String toString() { return "Circle(" + x + "," + y + ",r=" + r + ",fill=" + style.fill + ")"; }
}

class Registry {
    private final Map<String, Shape> map = new HashMap<>();
    void register(String k, Shape p) { map.put(k, p); }
    Shape create(String k) {
        Shape p = map.get(k);
        if (p == null) throw new IllegalArgumentException("No prototype: " + k);
        return p.deepCopy();
    }
}

public class Prototype {
    public static void main(String[] args) {
        Registry reg = new Registry();
        reg.register("redCircle", new Circle(10, 10, 20, new Style("#000", "#f00")));

        Circle c1 = (Circle) reg.create("redCircle");
        Circle c2 = (Circle) reg.create("redCircle");
        c2.r = 30; c2.style.fill = "#faa";

        System.out.println(c1);
        System.out.println(c2);
    }
}
