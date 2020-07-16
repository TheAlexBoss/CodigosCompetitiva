package adatraining;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class abejas {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);

        int T;
        boolean cond;

        while((T = scn.nextInt()) != 0){
            cond = true;
            int ans, read;
            ans = -1;
            for (int i = 0; i < T && cond; i++) {
                read = scn.nextInt();
                cond = ans < read;
                ans = read;
            }

            if(cond)
                pw.println("SI");
            else{
                pw.println("NO");
                scn.nextLine();
            }

        }

        pw.flush();

    }
}
