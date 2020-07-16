package CP0911;

import java.io.*;

public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            String[] str = br.readLine().split(" ");

            int max = Integer.parseInt(str[0]);
            for (int j = 1; j < N; j++) {
                max = Math.max(max, Integer.parseInt(str[j]));
            }

            pw.println(max);
        }

        pw.flush();
    }
}
