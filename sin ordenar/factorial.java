package com.company;

import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {

        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scn.nextInt();
            switch(N){
                case 0:
                case 1:
                    System.out.println(1);
                    break;
                case 2:
                case 4:
                    System.out.println(N);
                    break;
                case 3:
                    System.out.println(6);
                    break;
                default:
                    System.out.println(0);
            }
        }

    }

}
