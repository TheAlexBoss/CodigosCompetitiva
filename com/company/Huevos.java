package com.company;

import java.util.Scanner;

public class Huevos {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int H, C;


        while((H = scn.nextInt()) != 0 && (C = scn.nextInt()) != 0){
            int div = H/C;

            if(H%C!=0)
                div++;

            System.out.println(10*div);
        }
    }
}
