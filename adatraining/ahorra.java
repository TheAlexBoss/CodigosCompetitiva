package adatraining;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class ahorra {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);


        int dist, n, t0, v;
        while(scn.hasNext()){
            dist = scn.nextInt();
            n = scn.nextInt();

            int min = Integer.parseInt("3F3F3F3F",16);
            for (int i = 0; i < n; i++) {
                t0 = scn.nextInt();
                v = scn.nextInt();

                if(t0 >= 0){
                    int result = dist/v;
                    result += t0;

                    min = Math.min(min, result);
                }
            }

            pw.println(min);
        }

        pw.flush();
    }
}
