package com.hilllel.cw_06.task;

import java.util.Scanner;

public class Pus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Подходов: ");
        if (scanner.hasNextInt()) {
            int approaches = scanner.nextInt();
            int approachTime = 0;
            int breaks = 0;
            int breakIncrease = 60;
            int i = 0;

            while (i < approaches) {
                breakIncrease = (i != 0) ? (int) (breakIncrease * 1.2) : breakIncrease;
                i++;
                approachTime += i * 5;
                breaks += (i < approaches) ? breakIncrease : 0;
            }
            int time = breaks + approachTime;
            int hours = time / 3600,
                    min = time / 60 % 60,
                    sec = time % 60;

            String result = (approaches <= 0 || approaches > 20) ? "Некорректный ввод" : "Затрачено времени hh:mm:ss - " + String.format("%02d:%02d:%02d", hours, min, sec);
            System.out.println(result);
        } else System.out.println("Некорректный ввод");
    }
}
