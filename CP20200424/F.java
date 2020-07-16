package CP20200424;

import java.io.*;

public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] str = br.readLine().split(" ");

        int[] memo = new int[1000001];

        int obj = Integer.parseInt(str[0])/2;

        int res = DP(memo, Integer.parseInt(str[0]),  Integer.parseInt(str[1]),  Integer.parseInt(str[2]), obj);

        if(res == INF)
            System.out.println("Aww, snap...");
        else
            System.out.println(res);

    }

    static int INF = Integer.parseInt("3F3F3F3F", 16);
    public static int DP(int[] memo, int N, int K, int G, int obj){

        if(N == obj)
            return 0;

        if(N < obj)
            return INF;

        if(memo[N] != 0){
            return memo[N];
        }

        double ratio = 1/(double)K;
        int snap_survivors = N - (int) (N*ratio);
        int kick_survivors = N-G;

        int T1 = DP(memo, snap_survivors, K, G, obj);
        int T2 = DP(memo, kick_survivors, K, G, obj);



        memo[N] = Math.min(T1, T2);
        if(memo[N] != INF)
            memo[N]++;

        return memo[N];
    }
}
