package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class MaryPopins {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            System.out.println(reverseCase(br.readLine()));
        }

    }



    public static String reverseCase(String str){
        StringBuilder strb = new StringBuilder();
        LinkedList<Integer> indexes = new LinkedList<>();
        char mander;

        for (int i = 0; i < str.length(); i++) {
            mander = str.charAt(i);
            strb.insert(0,Character.toLowerCase(mander));

            if(mander == Character.toUpperCase(mander))
                indexes.add(i);
        }

        for(int i: indexes){
            strb.setCharAt(i, Character.toUpperCase(strb.charAt(i)));
        }

        return strb.toString();
    }
}
