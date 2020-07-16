package com.company;

        import java.io.OutputStreamWriter;
        import java.io.PrintWriter;
        import java.util.Scanner;

public class nochevieja {
    public static void main(String[] args) {
        int[] meses = {0,31,28,31,30,31,30,31,31,30,31,30,31};
        int[] cumuledMes = new int[meses.length];
        cumuledMes[0] = 0;
        for (int i = 1; i < meses.length; i++) {
            cumuledMes[i] = cumuledMes[i-1] + meses[i];
        }

        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);

        int N = scn.nextInt();

        for (int i = 0; i < N; i++) {
            int dia = scn.nextInt();
            int mes = scn.nextInt();

            int rest = 365 - dia - cumuledMes[mes-1];
            pw.println(rest);
        }

        pw.flush();
    }
}
