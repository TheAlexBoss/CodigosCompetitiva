package adatraining;

import java.io.BufferedReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.*;

public class bingo {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);

        int C;

        while((C = scn.nextInt()) != 0){
            int[] array = new int[C];

            for (int i = 0; i < C; i++) {
                array[i] = scn.nextInt();
            }


            HashSet<Integer> set = new HashSet<>();
            ArrayList<Integer> order = new ArrayList<>();
            for (int i = 0; i < C; i++) {
                for (int j = 0; j < C; j++) {
                    int r = Math.abs(array[i]-array[j]);
                    if(i!=j && !set.contains(r)){
                        set.add(r);
                        order.add(r);
                    }

                }
            }
            Collections.sort(order);
            for (int i = 0; i < order.size(); i++) {
                pw.print(order.get(i));
                if(i < order.size()-1)
                    pw.print(" ");
            }

            pw.println();

        }

        pw.flush();

    }
}
