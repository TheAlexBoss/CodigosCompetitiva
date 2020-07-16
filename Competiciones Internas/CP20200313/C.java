package CP20200313;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class C {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int R = scn.nextInt();

        for (int i = 0; i < R; i++) {
            int H = scn.nextInt();
            int P = scn.nextInt();

            ArrayList<Integer> platos = new ArrayList<>(P);
            for (int j = 0; j < P; j++) {
                platos.add(scn.nextInt());
            }

            Collections.sort(platos, Collections.reverseOrder());

            int sum = 0, sol = 0;
            boolean saciado = false;
            for (int j = 0; j < P && !saciado; j++) {
                sum += platos.get(j);
                saciado = sum >= H;
                sol++;
            }

            if(saciado)
                System.out.println(sol);
            else
                System.out.println("Sinpa");

        }
    }
}
