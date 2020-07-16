package adatraining;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class LDiciembre {

    static class Arista{
        int from, to;

        public Arista(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    static class State implements Comparable<State>{
        int nodo;
        int tiempo;

        public State(int nodo, int tiempo) {
            this.nodo = nodo;
            this.tiempo = tiempo;
        }

        @Override
        public int compareTo(State o) {
            return this.nodo-o.nodo;
        }
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt(), A = scn.nextInt();
        ArrayList<Arista>[] grafo = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            grafo[i] = new ArrayList<>();
        }

        for (int i = 0; i < A; i++) {
            int from = scn.nextInt(), to = scn.nextInt();
            grafo[from].add(new Arista(from, to));
            grafo[to].add(new Arista(to, from));
        }

        int max_node = 0, max_cc = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            int cc_i = articulation(grafo, N, i);

            if(max_cc < cc_i){
                max_cc = cc_i;
                max_node = i;
            }
        }

        System.out.println(max_node);


    }

    public static int articulation(ArrayList<Arista>[] grafo, int N, int node){
        ArrayList<Arista> aux = grafo[node];
        grafo[node] = new ArrayList<>();

        int cc = cc(grafo, N);

        grafo[node] = aux;
        return cc;
    }

    public static int cc(ArrayList<Arista>[] grafo, int N){
        boolean visitado[] = new boolean[N];
        int cuenta = 0;
        for (int i = 0; i < N; i++) {
            if(!visitado[i]){
                DFS(grafo,N,i,visitado);
                cuenta++;
            }
        }
        return cuenta;
    }

    public static void DFS(ArrayList<Arista>[] grafo,int N, int start, boolean[] visitado){
        ArrayDeque<State> pila = new ArrayDeque<>();
        pila.push(new State(start,0));
        visitado[start] = true;
        while(!pila.isEmpty()){
            State aux = pila.pop();
            for(Arista ady: grafo[aux.nodo]){
                int destino = ady.to;
                if(!visitado[destino]){
                    pila.push(new State(destino,0));
                    visitado[destino] = true;
                }
            }
        }
    }
}
