package com.company;

import java.io.FileNotFoundException;
import java.util.*;

public class SWERC2019K2 {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<Integer> predecesors = new LinkedList<>();
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt();
        int M = scn.nextInt();
        int node = scn.nextInt();

        ArrayList<Arista>[] graph = new ArrayList[N + 5];

        for (int i = 0; i < N +5; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int from = scn.nextInt();
            int to = scn.nextInt();

            if(to == node){
                predecesors.add(from);
            }else{
                graph[to].add(new Arista(to, from));
            }
        }

        StringBuilder str = new StringBuilder();
        HashSet<Integer>[] connections = new HashSet[N+5];

        for (int i = 0; i < N+5; i++) {
            connections[i] = new HashSet<>();
        }

        for (Integer n: predecesors) {
            findSolution(graph,connections, n,n);
        }

        int c = 0;
        Collections.sort(predecesors);
        for (Integer j: predecesors) {
            if(connections[j].size() == 1){
                str.append(j).append('\n');
                c++;
            }
        }

        System.out.println(c);
        System.out.print(str);
    }

    public static void findSolution(ArrayList<Arista>[] graph, HashSet<Integer>[] connections, int n, int r){

        if(connections[n].contains(r))
            return;

        if(connections[n].size() > 1)
            return;

        connections[n].add(r);

        for (Arista a: graph[n]){
            findSolution(graph, connections, a.to, r);
        }
    }
}

class Arista{
    int from, to;

    public Arista(int from, int to) {
        this.from = from;
        this.to = to;
    }
}