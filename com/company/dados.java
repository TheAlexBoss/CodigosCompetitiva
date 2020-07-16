package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class dados {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), false);
        Scanner scn = new Scanner(System.in);

        int N;
        Integer[] dado1 = new Integer[100000];
        Integer[] dado2 = new Integer[100000];

        while((N = scn.nextInt()) != 0){

            for (int i = 0; i < N; i++) {
                dado1[i] = scn.nextInt();
            }

            for (int i = 0; i < N; i++) {
                dado2[i] = scn.nextInt();
            }

            //nlogn
            Arrays.sort(dado1,0,N,Collections.reverseOrder());
            Arrays.sort(dado2,0,N,Collections.reverseOrder());

            int cont1= 0, cont2 = 0;
            int j= 0;

            for (int i = 0; i < N; i++) {
                if(dado1[j]<dado2[i]){
                    cont1+=(N-j);
                }else if(j<N-1){
                    while(j<N-1 && dado1[j]>= dado2[i]){
                        j++;
                    }

                    if(dado1[j] < dado2[i]){
                        cont1+=(N-j);
                    }
                }
            }

            j = 0;

            for (int i = 0; i < N; i++) {
                if(dado2[j]<dado1[i]){
                    cont2+=(N-j);
                }else if(j<N-1){
                    while(j<N-1 && dado2[j]>= dado1[i]){
                        j++;
                    }

                    if(dado2[j]<dado1[i]){
                        cont2+=(N-j);
                    }
                }
            }

            if(cont1 < cont2)
                pw.println("PRIMERO");
            else if(cont2 < cont1)
                pw.println("SEGUNDO");
            else
                pw.println("NO HAY DIFERENCIA");

        }

        pw.flush();

    }
}
