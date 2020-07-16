package com.company;

        import java.util.Scanner;

public class Navidad {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            int d = scn.nextInt(), m = scn.nextInt();

            if(d == 25 && m ==12)
                System.out.println("SI");
            else
                System.out.println("NO");
        }
    }
}
