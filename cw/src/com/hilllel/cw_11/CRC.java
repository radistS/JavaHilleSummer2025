package com.hilllel.cw_11;

import java.util.zip.CRC32;

public class CRC {
    public static void main(String[] args) {
        String input =  "Hello World!";
        String input1 = "Hello World!";

        CRC32 crc = new CRC32();
        crc.update(input.getBytes());
        System.out.println("input:"+input);
        System.out.println("CRC32:"+crc.getValue());

        CRC32 crc1 = new CRC32();
        crc1.update(input1.getBytes());
        System.out.println("input1:"+input1);
        System.out.println("CRC32:"+crc1.getValue());


    }
}
