package adatraining;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Playa {

    static class Info{
        int x,y,r;

        public Info(int x, int y, int r) {
            this.x = x;
            this.y = y;
            this.r = r;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            int C = scn.nextInt();

            ArrayList<Info> lista = new ArrayList<>(C);

            for (int j = 0; j < C; j++) {
                int X = scn.nextInt();
                int Y = scn.nextInt();
                int R = scn.nextInt();

                lista.add(new Info(X,Y,R));
            }

            int cont = 0;
            for (int j = 0; j < C; j++) {
                for (int k = j+1; k < C; k++) {
                    cont += superpuesto(lista.get(j), lista.get(k));
                }
            }

            System.out.println(cont);
        }


    }

    public static int superpuesto(Info a, Info b){
        double iz = Math.pow(a.x-b.x,2) + Math.pow(a.y-b.y,2);
        double de = Math.pow(a.r + b.r,2);

        if(iz < de)
            return 1;

        return 0;
    }
}
