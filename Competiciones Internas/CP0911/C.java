package CP0911;

import java.io.*;
import java.util.HashMap;

public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {

            int N = Integer.parseInt(br.readLine());
            HashMap<Integer,Integer> map = new HashMap<>();

            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int peseta = Integer.parseInt(str[j]);
                map.put(peseta, map.getOrDefault(peseta,0) +1);
            }

            int M = Integer.parseInt(br.readLine());
            long resultado = 0;
            for (int j = 0; j < M; j++) {
                str = br.readLine().split(" ");
                int peseta = Integer.parseInt(str[0]);
                long valor = Long.parseLong(str[1]);

                resultado += map.getOrDefault(peseta, 0)*valor;

            }

            pw.println(resultado);

        }

        pw.flush();
    }
}
