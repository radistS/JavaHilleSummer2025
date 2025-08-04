package com.hillel.tests;

import static org.junit.jupiter.api.Assertions.*;

import jdk.jfr.Description;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

class CalcTest {

    @Test
    @Tag("calc")
    @Description("add")
    void add() {
        assertEquals(4, new Calc().add(2, 2));
    }

    @Test
    @Tag("calc")
    @Description("div")
    void div() {
        assertEquals(1, new Calc().div(2, 2));
    }

    @Test
    @Tag("calc")
    @Description("div_0_ex")
    void divByZero() {
    assertThrows(ArithmeticException.class, () -> new Calc().div(2, 0));
    }

    @Tag("calc")
    @Description("div_0_corr")
    @RepeatedTest(15)
    void divZeroBy() {
        assertEquals(0, new Calc().div(0, (int) ((Math.random() * (20 - 1)) + 1)));
    }


    @Test
    @Tag("calc")
    @Description("sub")
    void sub() {
        assertEquals(0, new Calc().sub(2, 2));
    }
}
