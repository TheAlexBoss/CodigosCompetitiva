package chuletarioCP;

import sun.java2d.loops.GeneralRenderer;

import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class Ciclos {

    // EULERIANO:
    //  - CAMINO: C(v) % 2 == 0 || 2 vértices con C(v) % 2 == 1;
    //  - CICLO: C(v) % 2 == 0

    // HAMILTONIANO:

    public static boolean hamiltonianWay(ArrayList<Arista>[] grafo, int N, int init_node){
        boolean isHamiltonian = false;
        int mask = (2^N)-1;
        int aux;

        //BFS
        ArrayDeque<State> cola = new ArrayDeque<>();
        boolean[] visitado = new boolean[N];
        cola.offer(new State(init_node,0));
        visitado[0] = true;

        while(!cola.isEmpty()){
            State actual = cola.poll();
            aux = 1<<actual.nodo;

            if((mask & aux) > 0){
                mask ^= aux;
            }else{
                isHamiltonian = true;
                break;
            }

            for(Arista ady: grafo[actual.nodo]){
                int destino = ady.to;
                if(!visitado[destino]){
                    cola.offer(new State(destino, 0));
                    visitado[destino] = true;
                }
            }

        }

        // Para ver si es ciclo simplemente ver que el nodo actual es el mismo que el init_node
        return isHamiltonian;
    }

    public static void main(String[] args) {
        ArrayList<Arista>[] grafo = new ArrayList[3];
        for (int i = 0; i < 3; i++) {
            grafo[i] = new ArrayList<>();
        }

        grafo[0].add(new Arista(0, 1,0));
        grafo[1].add(new Arista(1, 0,0));
        grafo[1].add(new Arista(1, 2,0));
        grafo[2].add(new Arista(2, 1,0));
        grafo[0].add(new Arista(0, 2,0));
        grafo[2].add(new Arista(2, 0,0));

        System.out.println(hamiltonianWay(grafo, 3,1));

    }

    static class State{int nodo;int cosa;public State(int nodo, int cosa) { this.nodo = nodo;this.cosa = cosa; }}
    static class Arista{int from, to, peso;public Arista(int from, int to, int peso) { this.from = from;this.to = to; this.peso = peso;}}



}
