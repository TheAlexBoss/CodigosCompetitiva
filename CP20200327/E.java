package CP20200327;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class E {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();

        for (int i = 0; i < N; i++) {
            int from = scn.nextInt();
            int to = scn.nextInt();
            int[] memo = new int[1002];
            Arrays.fill(memo, -1);

            System.out.println(BFS(from, to));

        }
    }

    static class State{
        int nodo, distancia;

        public State(int nodo, int distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
        }
    }
    public static int BFS(int inicio,int fin){
        ArrayDeque<State> cola = new ArrayDeque<>();
        boolean visitado[] = new boolean[1002];

        cola.offer(new State(inicio,0));

        while(!cola.isEmpty()){
            State actual = cola.poll();

            if(actual.nodo == fin){
                return actual.distancia;
            }

            int uno = (actual.nodo + 1);
            int dos = (actual.nodo*2);
            int cinco = (actual.nodo-5);

            if(uno <= 1000 && !visitado[uno]){
                visitado[uno] = true;
                cola.offer(new State(uno,actual.distancia+1));
            }
            if(dos <= 1000 && !visitado[dos]){
                visitado[dos] = true;
                cola.offer(new State(dos,actual.distancia+1));
            }
            if(cinco >= 0 && !visitado[cinco]){
                visitado[cinco] = true;
                cola.offer(new State(cinco,actual.distancia+1));
            }

        }
        return -1;
    }

}
