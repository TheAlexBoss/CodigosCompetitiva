package adatraining;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

public class cubinfinito {
    static int[] c = {0, 1, 8, 27, 64, 125, 216, 343, 512, 729};
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N;
        HashSet<Integer> ci = new HashSet<>();

        while((N = scn.nextInt()) != 0){
            cubifinito(N, ci);
        }

        /*for (int i = 0; i < 10000000; i++) {

            cubifinito(i, ci);
        }*/

        for (int i: ci) {
            System.err.println(i);
        }
    }

    public static void cubifinito(int N, HashSet<Integer> ci){
        int aux = N;
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        pw.print(aux);
        HashSet<Integer> set = new HashSet<>();

        if(aux!= 1){
            while(aux != 1){
                aux = getN(aux);
                pw.print(' ');
                pw.print('-');
                pw.print(' ');
                pw.print(aux);
                if(set.contains(aux))
                    break;
                set.add(aux);
            }
        }

        if(aux == 1){
            pw.println(" -> cubifinito.");
            ci.add(N);
        }else{
            pw.println(" -> no cubifinito.");
        }

        pw.flush();
    }

    public static int getN(int n){
        int sum = 0;
        while(n > 0){
            sum += c[n%10];
            n /= 10;
        }
        return sum;
    }
}
