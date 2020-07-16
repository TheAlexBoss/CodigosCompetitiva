package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;

public class bipartiteHopcroft {

    static int INF = Integer.parseInt("3F3F3F3F",16);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int N = Integer.parseInt(str[0]);
        int M = Integer.parseInt(str[1]);

        ArrayList<Integer>[] graph = new ArrayList[N +1];
        ArrayList<Integer> nodes = new ArrayList<>(N +1);
        for (int i = 0; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        HashMap<String, Integer> traductor = new HashMap<>(N+1);
        for (int i = 1; i <= N; i++) {
            String lect = br.readLine();
            traductor.put(lect,i);
            nodes.add(i);
        }

        for (int i = 0; i < M; i++) {
            str = br.readLine().split(" ");
            graph[traductor.get(str[0])].add(traductor.get(str[1]));
            graph[traductor.get(str[1])].add(traductor.get(str[0]));
        }

        //Es simetrico
        System.out.println(2*hopcroft(graph, nodes, N, N));
    }

    public static int hopcroft(ArrayList<Integer>[] graph, ArrayList<Integer> leftNodes, int N, int M){
        int[] pair = new int[N+1];
        int[] dist = new int[N+1];
        int matching = 0;
        //Hopcroft
        while (bfs(graph, leftNodes, dist, pair)) {
            for (Integer nodo : leftNodes) {
                if (pair[nodo] == 0 && dfs(nodo, graph,dist, pair)) {
                    matching++;
                }
            }
        }
        return matching;
    }

    public static boolean bfs(ArrayList<Integer>[] graph, ArrayList<Integer> leftNodes, int[] dist, int[] pair) {
        ArrayDeque<Integer> que = new ArrayDeque<>();
        for (Integer u : leftNodes) {
            if (pair[u]==0){
                dist[u]=0;
                que.add(u);
            } else {
                dist[u] = INF;
            }
        }
        dist[0] = INF;
        while (!que.isEmpty()){
            int u = que.removeFirst();
            if (dist[u] < dist[0]) {
                for (Integer v : graph[u]) {
                    if (dist[pair[v]] == INF) {
                        dist[pair[v]] = dist[u] + 1;
                        que.add(pair[v]);
                    }
                }
            }
        }
        return dist[0]!=INF;
    }

    public static boolean dfs(int u, ArrayList<Integer>[] graph, int[] dist, int[] pair) {
        if (u != 0){
            for (Integer v : graph[u]) {
                if (dist[pair[v]] == dist[u]+1) {
                    if (dfs(pair[v], graph, dist, pair)){
                        pair[u] = v;
                        pair[v] = u;
                        return true;
                    }
                }
            }
            dist[u] = INF;
            return false;
        }
        return true;
    }

    /*public static int hopcroft(ArrayList<Integer>[] graph, int N, int M){
        int[] pairU = new int[M + 1];
        int[] pairV = new int[N + 1];
        int[] dist = new int[M + 1];
        int result = 0;

        while(bfs(graph,M,pairU,pairV,dist)){
            for (int u=1; u<=M; u++)
                if (pairU[u]==0 && dfs(graph, u, pairU, pairV,dist))
                    result++;
        }
        return result;
    }


    public static boolean bfs(ArrayList<Integer>[] adj, int M, int[] pairU, int[] pairV, int[] dist){
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        for (int u = 0; u <= M; u++) {
            if(pairU[u] == 0){
                dist[u] = 0;
                queue.offer(u);
            }else{
                dist[u] = INF;
            }
        }
        dist[0] = INF;

        while(!queue.isEmpty()){
            int u = queue.poll();
            if(dist[u] < dist[0]){
                for(Integer i: adj[u]){
                    if(dist[pairV[i]] == INF){
                        dist[pairV[i]] = dist[u] +1;
                        queue.offer(pairV[i]);
                    }
                }
            }
        }
        return (dist[0] != INF);
    }

    public static boolean dfs(ArrayList<Integer>[] adj, int u, int[] pairU, int[] pairV, int[] dist){
        if(u != 0){
            for (Integer i: adj[u]){
                if(dist[pairV[i]] == dist[u] + 1){
                    if (dfs(adj,pairV[i],pairU,pairV,dist)){
                        pairV[i] = u;
                        pairU[u] = i;
                        return true;
                    }
                }
            }
            dist[u] = INF;
            return false;
        }
        return true;
    }*/
}
