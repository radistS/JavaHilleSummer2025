package com.hilllel.cw_07.task;

/*
Маскування особистих даних
String maskSensitive(String input);
Приклад:
"Card number: 1234-5678-9876-5432" → "Card number: ****-****-****-5432"
 */

public class MaskData {

    public static void main(String[] args) {
        System.out.println(maskData("1314-5678-9876-5432"));

    }

    public static String maskData(String data){
        data = data.trim();
        if(!isDataValid(data)){
            throw new RuntimeException();
        }
        return "****-****-****-".concat(data.substring(data.length()-4, data.length()));
    }

    public static boolean isDataValid(String data){
        if (data.length() != 19) {
            return false;
        }

        if (data.charAt(0) == '0') {
            return false;
        }

        String[] octets = data.split("-");
        if (octets.length != 4) {
            return false;
        }

        for (String octet : octets) {
            if(octet.length() != 4){
                return false;
            }
            Integer.parseInt(octet);
        }

        return true;
    }

}
