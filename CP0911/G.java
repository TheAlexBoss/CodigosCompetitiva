package CP0911;

import java.io.*;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),true);

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String[] str = br.readLine().split(" ");

            int C = Integer.parseInt(str[0]);
            int O = Integer.parseInt(str[1]);

            int[] aux = new int[O+1];
            int posAux = 0;
            int suma = 0, sumaMaxima = 0;

            str = br.readLine().split(" ");

            for (int j = 0; j < C; j++) {
                aux[posAux] = Integer.parseInt(str[j]);
                suma = suma - aux[(posAux+1)%(O+1)] + aux[posAux];
                posAux = (posAux+1)%(O+1);
                sumaMaxima = Math.max(sumaMaxima,suma);
            }
            pw.println(sumaMaxima);

        }
        pw.flush();
    }
}
