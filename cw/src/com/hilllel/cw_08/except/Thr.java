package com.hilllel.cw_08.except;

import java.sql.SQLException;

public class Thr {
    public static void main(String[] args) {
        System.out.println("1111");
        try {
            Ex1.ex();
        } catch (IndexOutOfBoundsException | SQLException  e ) {
            e.printStackTrace();
        }
        System.out.println("2222");
    }
}

class Ex1 {
public static void ex() throws SQLException {
    throw new SQLException("sss");
}
}
