package CP20200313;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int C = scn.nextInt();

        for (int i = 0; i < C; i++) {
            int N = scn.nextInt();
            ArrayList<Integer> compra = new ArrayList<>(N);
            for (int j = 0; j < N; j++) {
                int T = scn.nextInt();
                int D = scn.nextInt();
                if(D == 1){
                    compra.add(T);
                }else{
                    int div = T/D;
                    for (int k = 0; k < D; k++) {
                        compra.add(div);
                    }
                }
            }



            int H = scn.nextInt();
            ArrayList<Integer> hueco = new ArrayList<>(H);

            for (int j = 0; j < H; j++) {
                hueco.add(scn.nextInt());
            }

            if(compra.size() > hueco.size())
                System.out.println("REGALAR COMIDA A LA VECINA");
            else{
                Collections.sort(compra, Collections.reverseOrder());
                Collections.sort(hueco, Collections.reverseOrder());

                boolean sePuede = true;
                for (int j = 0; j < compra.size() && sePuede; j++) {
                    if(hueco.get(j) < compra.get(j)){
                        sePuede = false;
                        break;
                    }
                }

                if(sePuede)
                    System.out.println("SUFICIENTE HUECO");
                else
                    System.out.println("REGALAR COMIDA A LA VECINA");
            }

        }
    }
}
