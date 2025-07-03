package com.hilllel.cw_04;

public class Predmet {
    private String Name;
    private int hours;

    public Predmet(String name) {
        Name = name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    @Override
    public String toString() {
        return "Predmet{" +
                "Name='" + Name + '\'' +
                ", hours=" + hours +
                '}';
    }
}
