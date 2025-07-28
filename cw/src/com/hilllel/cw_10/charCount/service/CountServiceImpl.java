package com.hilllel.cw_10.charCount.service;



import com.hilllel.cw_10.charCount.Letter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class CountServiceImpl implements CountService {

    @Override
    public String normalizeText(String text) {
        String[] strArray = text.split("");
        StringBuilder sb = new StringBuilder();
        for (String s : strArray){
            if (Character.isAlphabetic(s.charAt(0)) || Character.isDigit(s.charAt(0)))
                sb.append(s.toLowerCase(Locale.ROOT));
        }
        return sb.toString();
    }

    @Override
    public Map<String, Integer> createDictionary(String text) {
        Map<String, Integer> dictionary = new HashMap<>();
        String[] strArray = text.split("");
        for (String s : strArray){
            if (!dictionary.containsKey(s)){
                dictionary.put(s, 1);
            } else {
                dictionary.put(s, dictionary.get(s) + 1);
            }
        }
        return dictionary;
    }

    @Override
    public List<Letter> convertMapToList(Map<String, Integer> dictionary, String text) {
        List<Letter> letters = new ArrayList<>();

        Set<Map.Entry<String, Integer>> entries = dictionary.entrySet();

        for(Map.Entry<String, Integer> entry : entries){
            letters.add(new Letter(
                    entry.getKey(),
                    entry.getValue(),
                    ((float) entry.getValue() / (float)text.length())*100)
            );
        }
        return letters;
    }
}
