package chuletarioCP;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Hopcroft {
    static int INF = -1;
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
}
