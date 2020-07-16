package clasificatorioSWERC19;

import java.io.*;
import java.util.Scanner;

public class B2 {

    static int INF = Integer.parseInt("3F3F3F3F",16);

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        Scanner scn = new Scanner(System.in);

        int N;
        while((N = scn.nextInt()) != -1){
            int[] costes = new int[N];
            int[] max = new int[N+1];
            max[0] = 0;

            for (int i = 1; i < N+1; i++) {
                costes[i-1] = scn.nextInt();
                int maxTemp = -INF;
                for (int j = 0; j < i; j++)
                    maxTemp = Math.max(maxTemp, costes[j] + max[i - j - 1]);
                max[i] = maxTemp;
            }
            pw.println(max[N]);


        }
        pw.flush();
    }
}
