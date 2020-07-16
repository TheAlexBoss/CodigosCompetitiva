package chuletarioCP;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Dijsktra {

    public static int dijsktra(ArrayList<Arista>[] graph, int from, int to){
        PriorityQueue<State> queue = new PriorityQueue<>();
        int[] distancia = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            distancia[i] = INF;
        }
        queue.offer(new State(from, 0));
        distancia[from] = 0;

        while(!queue.isEmpty()){
            State actual = queue.poll();

            //si solo queremos ir de un lado a otro
            if(actual.node == to)
                return actual.dist;

            for(Arista ady: graph[actual.node]){
                // if(!visitado[actual.nodo]) y sacar el offer del 2o if
                if (distancia[ady.to] >= ady.distancia + actual.dist) {
                    distancia[ady.to] = ady.distancia + actual.dist;
                    queue.offer(new State(ady.to, distancia[ady.to]));
                }
            }
            //visitado[actual.nodo] = true;
        }
        return -1;
    }


    static class Arista{int from, to, distancia;}
    static class State{int node, dist; public State(int node, int dist){this.node=node;this.dist=dist;}}
    static int INF;

}
