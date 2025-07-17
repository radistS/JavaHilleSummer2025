package com.hilllel.cw_08.except;

public class ThrowsException {
    public static void main(String[] args)  {

        try {
            new People().print();
        } catch (BussinesException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("ssss");
    }
}

class People {
    void print() throws BussinesException {
        throw new BussinesException("Business exception : IOException ");
    }
}

