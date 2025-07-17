package com.hilllel.cw_08.except;

public class TCCCC {
    public static void main(String[] args) {
        try {
            switch ("1"){
                case "1": throw new RuntimeException();
                case "2": throw new Exception();
                case "3": throw new Throwable();
                default:
                    System.out.println("code ...");
            }
        } catch (RuntimeException ex) {
            System.err.println("RE");
        } catch (Exception ex) {
            System.err.println("E");
        } catch (Throwable ex) {
            System.err.println("T");
        }
        System.err.println("4");
    }
}
