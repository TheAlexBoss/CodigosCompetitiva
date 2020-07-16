package CP20200424;

import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int A = scn.nextInt(), M  = scn.nextInt();

        while(A != 0 || M != 0){
            int[] articulos = new int[A];
            int[] memo = new int[M+1];
            for (int i = 0; i < A; i++) {
                articulos[i] = scn.nextInt();
            }

            System.out.println(DP(memo, articulos, M, 0));
            A = scn.nextInt();
            M = scn.nextInt();
        }
    }

    static int INF = Integer.parseInt("3F3F3F3F", 16);
    public static int DP(int[] memo, int[] articulos, int current_monedas, int i){
        if(current_monedas == 0){
            return 0;
        }

        if(i >= articulos.length || current_monedas < 0)
            return INF;

        if(memo[current_monedas] != 0)
            return memo[current_monedas];

        int T1 = DP(memo, articulos, current_monedas-articulos[i], i) + 1;
        int T2 = DP(memo, articulos, current_monedas, i+1);

        memo[current_monedas] = Math.min(T1, T2);
        return memo[current_monedas];
    }
}
