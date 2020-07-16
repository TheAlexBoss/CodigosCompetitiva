package com.company;

import java.util.Scanner;

public class Kaprekar {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            int N = scn.nextInt(), c = 0;
            int max, min;
            while(N != 6174 && N!= 0){
                max = computeMax(N);
                min = computeMin(N);
                N = max - min;
                c++;
            }

            if(N == 0)
                System.out.println(8);
            else
                System.out.println(c);
        }

    }

    public static int computeMin(int N){
        StringBuilder strb = complete(N);
        int[] arr = new int[10];

        for (int i = 0; i < 4; i++) {
            arr[strb.charAt(i)-48]++;
        }

        int index = 0;
        for (int i = 0; i < 10; i++) {
            if(arr[i] > 0){
                strb.setCharAt(index,(char) (i+48));
                index++;
                arr[i]--;
                i--;
            }
        }
        return Integer.parseInt(strb.toString());
    }

    public static int computeMax(int N){
        StringBuilder strb = complete(N);
        int[] arr = new int[10];

        for (int i = 0; i < 4; i++) {
            arr[strb.charAt(i)-48]++;
        }

        int index = 0;
        for (int i = 9; i >= 0; i--) {
            if(arr[i] != 0){
                strb.setCharAt(index,(char) (i+48));
                index++;
                arr[i]--;
                i++;
            }
        }
        return Integer.parseInt(strb.toString());
    }

    public static StringBuilder complete(int N){
        if(N%10 == N){//Tiene 1 cifra
            StringBuilder strb = new StringBuilder(Integer.toString(N));
            strb.insert(0,'0');
            strb.insert(0,'0');
            strb.insert(0,'0');
            return strb;
        }else if(N % 100 == N){//Tiene 2 cifras
            StringBuilder strb = new StringBuilder(Integer.toString(N));
            strb.insert(0,'0');
            strb.insert(0,'0');
            return strb;
        }else if(N % 1000 == N){//Tiene 3 cifras
            StringBuilder strb = new StringBuilder(Integer.toString(N));
            strb.insert(0,'0');
            return strb;
        }

        return new StringBuilder(Integer.toString(N));
    }
}
