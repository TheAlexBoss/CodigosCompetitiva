package com.company;

import java.util.Scanner;

public class Rectangulos {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N,M;

        while((N = scn.nextInt()) >= 0 && (M = scn.nextInt()) >= 0){
            System.out.println(2*N+2*M);
        }
    }
}
