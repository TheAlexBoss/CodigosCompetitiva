package com.company;
import java.math.BigInteger;
import java.util.Scanner;

public class cargandoMovil {
    final static BigInteger INF_BIG = new BigInteger("3F3F3F3F",16);
    final static BigInteger DOS = new BigInteger("2");


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        while(scn.hasNext()){
            int C = scn.nextInt(), F = scn.nextInt(); // Columnas, filas
            int[][] graph = new int[F][C];

            for (int i = 0; i < F; i++) {
                for (int j = 0; j < C; j++) {
                    graph[i][j] = scn.nextInt();
                }
            }

            BigInteger[][] memo = new BigInteger[F][C];
            System.out.println(dp(graph, memo, 0, 0));
        }
    }


    public static BigInteger dp(int[][] grafo, BigInteger[][] memo, int i, int j){
        if(i == grafo.length-1 && j == grafo[0].length-1){
            memo[i][j] = DOS;
            return DOS;
        }

        if(memo[i][j] != null)
            return memo[i][j];

        BigInteger T1 = INF_BIG, T2= INF_BIG;

        if(j+1 < grafo[0].length)
            T1 = dp(grafo, memo, i, j+1);

        if(i+1 < grafo.length)
            T2 = dp(grafo, memo, i+1, j);

        memo[i][j] = INF_BIG.min(T1).min(T2).subtract(new BigInteger(Integer.toString(grafo[i][j])));

        memo[i][j] = DOS.max(memo[i][j]);

        return memo[i][j];
    }
}
