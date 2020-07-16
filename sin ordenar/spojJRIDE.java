package com.company;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class spojJRIDE {

    static final int INF = Integer.parseInt("3F3F3F3F",16);
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), false);

        int R = scn.nextInt();

        for (int i = 0; i < R; i++) {
            int B = scn.nextInt();
            int[] rating = new int[B-1];

            for (int j = 0; j < B - 1; j++) {
                rating[j] = scn.nextInt();
            }

            pw.println(dp(rating,i+1));
        }

        pw.flush();

    }


    public static String dp(int[] array, int route){
        int N = array.length;
        int[] soluciones = new int[N + 1];
        int fromV = -1, toV = -1;
        int from = -1, to = -1;

        soluciones[0] = -INF;
        for (int v = 1; v <= N; v++) {
            int maxVentana = -INF;
            for (int i = 0; i <= N-v; i++) {
                int suma = 0;
                for (int j = 0; j <= v -1; j++) {
                    suma+= array[i+j];
                }
                //maxVentana = Math.max(suma, maxVentana);

                if(suma >= maxVentana){
                    if(suma == maxVentana && v <= fromV-toV) {
                        if (v == fromV - toV && i < fromV) {
                            fromV = i+1;
                            toV = i + v+1;
                        }
                    }else if(suma != maxVentana){
                        fromV = i+1;
                        toV = i + v+1;
                    }

                    maxVentana = suma;
                }
            }
            //soluciones[v] = Math.max(maxVentana, soluciones[v-1]);

            if(maxVentana >= soluciones[v-1]){
                soluciones[v] = maxVentana;
                if(((maxVentana == soluciones[v-1] && v >= from - to) && (v != from - to || fromV < from)) || (maxVentana != soluciones[v-1]))
                    from = fromV;
                to = toV;
            }else{
                soluciones[v] = soluciones[v-1];
            }
        }

        if(soluciones[N] > 0)
            return "The nicest part of route " + route +" is between stops "+from+" and "+to;

        return "Route "+route+" has no nice parts";
    }
}
