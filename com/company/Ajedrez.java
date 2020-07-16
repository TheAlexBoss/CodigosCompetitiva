package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Ajedrez {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int N, M;
        char[] map = {' ', 'h', 'g' ,'f','e','d','c','b','a'};
        while ((N=scn.nextInt()) != 0 && (M=scn.nextInt()) != 0) {

            System.out.println(map[N]+""+M);

        }
    }
}
