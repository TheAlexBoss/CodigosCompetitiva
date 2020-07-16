package codeF161119;

import java.io.*;

public class A {
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());

            int a[] = new int[N];

            String[] str = br.readLine().split(" ");

            for (int j = 0; j < N; j++) {
                a[j] = Integer.parseInt(str[j]);
            }

            str = br.readLine().split(" ");
            int dif, ansDif = 0;
            int edit = 0;

            for (int j = 0; j < N; j++) {
                dif = Integer.parseInt(str[j]) - a[j];

                if(dif < 0){
                    edit = 3;
                    break;
                }


                if(dif != ansDif){
                    if(dif != ansDif)
                        edit++;
                    ansDif = dif;

                }
            }

            if(edit<2)
                pw.println("YES");
            else
                pw.println("NO");


        }

        pw.flush();


    }
}
