package clasificatorioSWERC19;

import java.io.*;

public class B {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;
        int cont = 0;
        while((N = Integer.parseInt(br.readLine())) != -1){
            String[] str = br.readLine().split(" ");
            int[][] memo = new int[N+1][N+1];
            pw.println(dp(str,memo,0,N,0));
            for (int i = 0; i < N+1; i++) {
                for (int j = 0; j < N+1; j++) {
                    System.err.print(memo[i][j] + " ");
                    cont++;
                }
                System.err.println();
            }
        }

        System.err.println(cont);
        System.err.println(cont2);



        pw.flush();
    }

    static int cont = 0, cont2 = 0;

    static int INF = Integer.parseInt("3F3F3F3F",16);
    public static int dp(String[] beneficios, int[][] memo, int i, int peso, int beneficio){
        if(peso <= 0)
            return beneficio;

        if(peso < (i+1) || i>=beneficios.length)
            return -INF;

        if(memo[peso][i]!= 0){
            cont++;
            return memo[peso][i];
        }


        int profit = Integer.parseInt(beneficios[i]);


        int T1 = dp(beneficios, memo, i,peso-(i+1),beneficio+profit);
        int T2 = dp(beneficios, memo, i+1,peso,beneficio);

        memo[peso][i] = Math.max(T1, T2);
        return memo[peso][i];
    }
}
