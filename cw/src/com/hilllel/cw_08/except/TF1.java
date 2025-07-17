package com.hilllel.cw_08.except;

import java.io.IOException;

public class TF1 {
    public static void main(String[] args) {
        try {
            throw new BussinesException("test");
        }catch (IOException ex){
            System.out.println(ex.getMessage());
        }
        finally {
            System.out.println("finaly");
        }
    }
}
