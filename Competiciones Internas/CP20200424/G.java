package CP20200424;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] memo = new int[N];
        Arrays.fill(memo, -1);
        String number = br.readLine();

        System.out.println(DP(memo, N, number, 0, 0));

        for (int i = 0; i < N; i++) {

        }
    }


    public static int DP(int[] memo, int size, String number, int cumuled, int i){
        // 48
        if(i >= size)
            return 0;

        if(memo[i] != -1)
            return memo[i];


        int count = cumuled + (number.charAt(i) - 48);
        int counting = 0;
        if(count == 42){
            counting = 1;
            count = 0;
        }

        int T1 = DP(memo, size, number, count, i+1) + counting;
        int T2 = DP(memo, size, number, cumuled, i+1);

        memo[i] = Math.max(T1, T2);

        return memo[i];
    }
}
