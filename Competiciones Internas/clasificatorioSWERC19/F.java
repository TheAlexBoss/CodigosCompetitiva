package clasificatorioSWERC19;

import java.io.*;

public class F {
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");
            int count = 0;
            int M = Integer.parseInt(str[0]);

            for (int j = 2; j < M+1; j++) {
                int ans = Integer.parseInt(str[j-1]);
                int actual = Integer.parseInt(str[j]);

                if(ans+1 == actual)
                    count++;
            }

            if(count == M-1)
                pw.println("BROKEN");
            else
                pw.println("WORKING");
        }

        pw.flush();

    }
}
