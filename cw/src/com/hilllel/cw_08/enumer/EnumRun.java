package com.hilllel.cw_08.enumer;

public class EnumRun {
    public static void main(String[] args) {
        for (UserStatus us : UserStatus.values()){
            System.out.println(us);
        }


        System.out.println(UserStatus.valueOf("ACTIVE"));
        System.out.println(UserStatus.valueOf("ACTIVE"));
    }
}
