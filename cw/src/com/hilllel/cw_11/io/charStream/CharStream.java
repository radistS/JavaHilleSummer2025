package com.hilllel.cw_11.io.charStream;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CharStream {
    public static void main(String[] args) {
        try (FileReader fr = new FileReader("/Users/oleksandrstepurko/IdeaProjects/JavaHilleSummer2025-https/cw/src/com/hilllel/cw_11/io/charStream/input.txt");
             FileWriter fw = new FileWriter("/Users/oleksandrstepurko/IdeaProjects/JavaHilleSummer2025-https/cw/src/com/hilllel/cw_11/io/charStream/output.txt")) {

            List<Character> list = new ArrayList<>();
                       int a;
            StringBuilder sb = new StringBuilder();
            while ((a = fr.read()) != -1) {
                list.add((char) a);
                fw.write(a);
                sb.append((char) a);
            }
            String text = sb.toString();
            System.out.println(text);

            String[] t = text.split("\n");

            System.out.println(t.length);

//            t[13] = "add value";

            System.out.println();
            sb = new StringBuilder();
            for (String str : t){
                sb.append(str).append("\n");
            }

            System.out.println(sb.toString());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
