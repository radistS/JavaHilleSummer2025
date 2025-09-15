package com.hilllel.cw_21.ex;

import java.sql.SQLException;

public class Ex5 {
    private static void checkData() throws SQLException {
        try {
            throw new SQLException();
        } catch (Exception e) {
            e = null;
            System.out.println(e.getCause());
            throw null;
//            throw new RuntimeException();
        }
    }

    public static void main(String[] args) {
        try {
            checkData();
        } catch (SQLException | RuntimeException e) {
//        } catch (SQLException e) {
            System.out.println(e.fillInStackTrace());
            System.out.println("NOT AVAILABLE");
        }
    }
}
