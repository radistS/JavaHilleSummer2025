package com.hilllel.cw_10.charCount;

/*
a - 10
b - 15
c - 20
 */


import com.hilllel.cw_10.charCount.service.CountService;
import com.hilllel.cw_10.charCount.service.CountServiceImpl;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

public class RunCount {
    public static void main(String[] args) {
        CountService cs = new CountServiceImpl();
        String text = cs.normalizeText(Text.getText());
        Map<String, Integer> dictionary = cs.createDictionary(text);
        List<Letter> letters = cs.convertMapToList(dictionary, text);

        letters.sort(Comparator.comparing(Letter::getCount).reversed());
        letters.forEach(System.out::println);

    }

}

