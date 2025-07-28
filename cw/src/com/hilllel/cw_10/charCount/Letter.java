package com.hilllel.cw_10.charCount;

import java.util.Objects;

public class Letter {
    private String letter;
    private int count;
    private float percent;

    public Letter(String letter, int count, float percent) {
        this.letter = letter;
        this.count = count;
        this.percent = percent;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public float getPercent() {
        return percent;
    }

    public void setPercent(float percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Letter letter1 = (Letter) o;
        return count == letter1.count && Float.compare(letter1.percent, percent) == 0 && Objects.equals(letter, letter1.letter);
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, count, percent);
    }

    @Override
    public String toString() {
        return "L = " + letter +
                ", C = " + count +
                ", P = " + percent;
    }
}
