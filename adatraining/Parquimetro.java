package adatraining;

import java.util.HashSet;
import java.util.Scanner;

public class Parquimetro {
    // MAL

    public static int[][] combs = new int[11][11];

    public static void main(String[] args) {
        combinatorios();
        printeo();
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            HashSet<Integer> set = new HashSet<>();
            int N = scn.nextInt(), C = scn.nextInt();
            int solution = 0;
            int[] coins = new int[N];

            for (int j = 0; j < N; j++) {
                coins[j] = scn.nextInt();
            }

            for (int j = 1; j <= C; j++) {
                solution += combs[C][j];
            }

            for (int j = 0; j < N; j++) {
                for (int k = 1 ;k <= C; k++) {
                    solution++;
                }
            }

            System.out.println(solution);
        }
    }

    public static void printeo(){
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                System.out.print(combs[i][j] + " ");
            }
            System.out.println();
        }
    }


    public static void combinatorios(){
        for (int i = 1; i < 11; i++) {
            combs[i][i] = 1;
            combs[1][i] = 1;
        }

        for (int i = 0; i < 11; i++) {
            for (int j = 1; j < i; j++) {
                combs[i][j] = combs[i-1][j-1] + combs[i-1][j];
            }
        }

    }
}
