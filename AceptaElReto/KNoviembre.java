package adatraining;

import java.util.Scanner;

public class KNoviembre {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int T = scn.nextInt();
        for (int i = 0; i < T; i++) {
            int N = scn.nextInt();
            int P = scn.nextInt();

            // flase: cerrada, true: abierta
            boolean[] abierta = new boolean[N+2];
            int[] abro = new int[N+2];
            for (int j = 0; j < N + 2; j++) {
                abierta[j] = true;
                abro[j] = -1;
            }

            for (int j = 0; j < P; j++) {
                int C = scn.nextInt();
                int O = scn.nextInt();
                abierta[C] = false;
                abro[O] = C;
            }

            int alice = 1, bob = N;

            while(alice < bob && (abierta[alice] || abierta[bob])){
                while(abierta[alice] && alice < bob ){
                    if(abro[alice] != -1){
                        abierta[abro[alice]] = true;
                    }
                    alice++;
                }
                while(abierta[bob] && alice < bob ){
                    bob--;
                    if(abro[bob] != -1){
                        abierta[abro[bob]] = true;
                        break;
                    }
                }
            }

            if(alice >= bob)
                System.out.println(alice);
            else
                System.out.println("Encerrados para siempre.");
        }
    }
}
