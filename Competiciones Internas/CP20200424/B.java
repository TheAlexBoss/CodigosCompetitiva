package CP20200424;

import java.io.*;

public class B {
    static int INF = Integer.parseInt("3F3F3F3F", 16);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        String[] lect = br.readLine().split(" ");
        int F = Integer.parseInt(lect[0]);
        int C = Integer.parseInt(lect[1]);
        int L = Integer.parseInt(lect[2]);

        int[][] memo = new int[F][C];
        String[][] tab = new String[F][C];
        memo[F-1][C-1] = 0;

        for (int i = 0; i < F; i++) {
            lect = br.readLine().split(" ");
            for (int j = 0; j < C; j++) {
                tab[i][j] = lect[j];
            }
        }


        for (int i = F-1; i >= 0; i--) {
            for (int j = C-1; j >= 0; j--) {
                if(i != F-1 || j!= C-1){
                    int a = INF, b = INF;
                    if(i < F-1){
                        a = memo[i+1][j] + calc(tab[i][j], tab[i+1][j]);
                    }
                    if(j < C-1){
                        b = memo[i][j+1] + calc(tab[i][j], tab[i][j+1]);
                    }

                    memo[i][j] = Math.min(a, b);
                }

            }
        }

        System.out.println(memo[0][0]);
    }


    public static int calc(String a, String b){
        int sol = 0;

        for (int i = 0; i < a.length(); i++) {
            if(a.charAt(i) != b.charAt(i)){
                sol++;
            }
        }

        return sol;
    }

}
