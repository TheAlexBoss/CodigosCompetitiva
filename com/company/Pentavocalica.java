package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Pentavocalica {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean sePuede;

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            HashSet<Character> set = new HashSet<>();
            sePuede = false;
            for (int j = 0; j < str.length(); j++) {
                if(str.charAt(j) == 'a' || str.charAt(j) == 'e' || str.charAt(j) == 'i' || str.charAt(j) == 'o' || str.charAt(j) == 'u')
                    set.add(str.charAt(j));

                if(set.size() == 5){
                    sePuede = true;
                    break;
                }
            }
            if(sePuede)
                System.out.println("SI");
            else
                System.out.println("NO");
        }
    }
}
