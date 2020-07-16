package adatraining;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class CompeTencia {


    static class Pair implements Comparable<Pair>{
        int meto, no_meto, resta;

        public Pair(int compe, int tencia) {
            this.meto = compe;
            this.no_meto = tencia;
        }

        @Override
        public int compareTo(Pair o) {
            this.resta = this.meto-this.no_meto;
            o.resta = o.meto-o.no_meto;
            return o.resta-this.resta;
        }
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);


        int N;
        while((N = scn.nextInt()) != 0){
            int C = scn.nextInt(), T = scn.nextInt();

            int[] compe = new int[N];
            int[] tencia = new int[N];

            for (int i = 0; i < N; i++) {
                compe[i] = scn.nextInt();
            }

            for (int i = 0; i < N; i++) {
                tencia[i] = scn.nextInt();
            }


            PriorityQueue<Pair> com = new PriorityQueue<>();
            PriorityQueue<Pair> ten = new PriorityQueue<>();

            int sol = 0;
            Pair aux;
            for (int i = 0; i < N; i++) {
                sol += Math.min(compe[i], tencia[i]);
                if(compe[i] < tencia[i]){
                    com.offer(new Pair(compe[i], tencia[i]));
                    C--;
                }else{
                    ten.offer(new Pair(tencia[i], compe[i]));
                    T--;
                }

            }


            while(C>0){
                aux = ten.poll();
                sol += (aux.no_meto - aux.meto);
                C--;
                T++;
            }

            while(T>0){
                aux = com.poll();
                sol += (aux.no_meto - aux.meto);
                C++;
                T--;
            }


            System.out.println(sol);

    }
    }
}
