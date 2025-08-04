package com.hillel.tests.user;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

class UserCalculateTest {

    @Test
    void getFullName(){
        UserCalculate userCalculate = new UserCalculate();

        User user = new User();
        user.setName("John");

        assertEquals("John John", userCalculate.calculateFullName(user.getName()));
    }

    @Test
    void getFullName_mock(){
        UserCalculate userCalculate = mock(UserCalculate.class);
        User user = new User();
        user.setName("John");

        when(userCalculate.calculateFullName(any())).thenReturn("any any");
        when(userCalculate.calculateFullName("John")).thenReturn("John mock");
        assertEquals("John mock", userCalculate.calculateFullName(user.getName()));

        user.setName("");
        assertEquals("any any", userCalculate.calculateFullName(user.getName()));

        verify(userCalculate, times(2)).calculateFullName(any());
        verify(userCalculate, times(1)).calculateFullName("John");
    }

    @Test
    void getFullName_mock_seq(){
        UserCalculate userCalculate = mock(UserCalculate.class);
        User user = new User();
        user.setName("John");

        when(userCalculate.calculateFullName(any())).thenReturn("a").thenReturn("b").thenReturn("c");

        assertEquals("a", userCalculate.calculateFullName(user.getName()));
        assertEquals("b", userCalculate.calculateFullName("John"));
        assertEquals("c", userCalculate.calculateFullName("John"));
        assertEquals("c", userCalculate.calculateFullName("John"));
        assertEquals("c", userCalculate.calculateFullName("John"));

    }
}
