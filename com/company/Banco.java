package com.company;

import java.util.Scanner;

public class Banco {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            int a = scn.nextInt(), b = scn.nextInt();
            if(a+b >= 0)
                System.out.println("SI");
            else
                System.out.println("NO");
        }
    }
}
