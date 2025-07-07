package com.hilllel.cw_05.interfaces;

public class MainLang {
    public static void main(String[] args) {
        Say say;

        if (args.length != 0 && args[0].equals("rus")) {
            say = new Rus();
        } else {
            say = new Engl();
        }

        say.sayHello(); // SayHello
        say.sayGoodBuy(); // Say
        Say.hello();

        if (say instanceof Engl) {
            Engl eng = (Engl) say;

            eng.sayHello();
            eng.sayGoodBuy();
        }

        if (say instanceof Rus) {
            Rus rus = (Rus) say;
            System.out.println(rus.xxx());
        }



    }
}
