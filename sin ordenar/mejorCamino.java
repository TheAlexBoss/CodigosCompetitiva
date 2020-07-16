package com.company;

import java.math.BigInteger;
import java.util.*;

// https://aceptaelreto.com/problem/statement.php?id=504&cat=122
public class mejorCamino {
    final static int INF = Integer.parseInt("3F3F3F3F",16);
    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);

        while(scn.hasNext()){
            int V = scn.nextInt(), A = scn.nextInt();

            ArrayList<Arista>[] graph = new ArrayList[V];
            for (int i = 0; i < V; i++) {
                graph[i] = new ArrayList<>(50);
            }

            for (int i = 0; i < A; i++) {
                int from = scn.nextInt()-1, to = scn.nextInt()-1, dist = scn.nextInt();

                graph[from].add(new Arista(from, to, dist));
                graph[to].add(new Arista(to, from, dist));
            }

            int k = scn.nextInt();

            for (int i = 0; i < k; i++) {
                int from = scn.nextInt()-1, to = scn.nextInt()-1;

                int bfs = bfs(graph, from, to);
                if(bfs != 0){
                    int[] dj = dijsktra(graph, from, to);
                    if(dj[1] == bfs){
                        System.out.println(dj[0] + " SI");
                    }else{
                        System.out.println(dj[0] + " NO");
                    }
                }else{
                    System.out.println("SIN CAMINO");
                }
            }
            System.out.println("----");
        }
    }

    public static int bfs(ArrayList<Arista>[] graph, int from, int to){
        ArrayDeque<State> queue = new ArrayDeque<>();
        boolean[] visitado = new boolean[graph.length];
        queue.add(new State(from, 0, 0));

        while(!queue.isEmpty()){
            State actual = queue.poll();
            if(actual.node == to)
                return actual.calles;
            for (Arista ady: graph[actual.node]){
                if(!visitado[actual.node])
                    queue.offer(new State(ady.to, 0, actual.calles +1));
            }
            visitado[actual.node] = true;
        }
        return 0;
    }

    public static int[] dijsktra(ArrayList<Arista>[] graph, int from, int to){
        PriorityQueue<State> queue = new PriorityQueue<>();
        int[] distancia = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            distancia[i] = INF;
        }
        queue.offer(new State(from, 0, 0));
        distancia[from] = 0;

        while(!queue.isEmpty()){
            State actual = queue.poll();

            if(actual.node == to)
                return new int[] {actual.dist, actual.calles};

            for(Arista ady: graph[actual.node]){
                if (distancia[ady.to] >= ady.distancia + actual.dist) {
                    distancia[ady.to] = ady.distancia + actual.dist;
                    queue.offer(new State(ady.to, distancia[ady.to], actual.calles+1));
                }
            }
        }
        return new int[] {INF, 0};
    }

    static class Arista{
        int from, to, distancia;

        public Arista(int from, int to, int distancia) {
            this.from = from;
            this.to = to;
            this.distancia = distancia;
        }
    }

    static class State implements Comparable<State>{
        int node, dist, calles;

        public State(int from, int dist, int calles) {
            this.node = from;
            this.dist = dist;
            this.calles = calles;
        }

        @Override
        public int compareTo(State o) {
            if(this.dist < o.dist){
                return -1;
            }else if(this.dist > o.dist){
                return 1;
            }else{
                return Integer.compare(this.calles, o.calles);
            }
        }
    }
}
