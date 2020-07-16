package CP0911;

import java.io.*;
import java.util.HashSet;

public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            HashSet<Integer> boleto = new HashSet<>();

            int N = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                boleto.add(Integer.parseInt(str[j]));
            }

            str = br.readLine().split(" ");
            int ronda = 0, nActual;
            while((nActual = Integer.parseInt(str[ronda]))!= -1 && !boleto.isEmpty()){
                boleto.remove(nActual);

                if(boleto.isEmpty()){
                    pw.println("BINGO!! " + (ronda +1));
                }

                ronda++;
            }
        }

        pw.flush();
    }
}
