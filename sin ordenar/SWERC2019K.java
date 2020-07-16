package com.company;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class SWERC2019K {
    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner scn = new Scanner(System.in);
        //String[] input = br.readLine().split(" ");

        int N = scn.nextInt(); //Integer.parseInt(input[0]);
        int M = scn.nextInt(); //Integer.parseInt(input[1]);
        int node = scn.nextInt(); //Integer.parseInt(input[2]);

        System.err.println(N);
        System.err.println(M);

        ArrayList<Arista>[] graph = new ArrayList[N + 5];

        for (int i = 0; i < N +5; i++)
            graph[i] = new ArrayList<>();

        System.err.println(node);

        for (int i = 0; i < M; i++) {
            //input = br.readLine().split(" ");
            int from = scn.nextInt(); //Integer.parseInt(input[0]);
            int to = scn.nextInt(); //Integer.parseInt(input[0]);
            graph[to].add(new Arista(to, from));
        }

        StringBuilder str = new StringBuilder();

        int cont = 0;
        for (Arista a: graph[node]) {
            if(!connected(graph, node, a.to, N)){
                str.append(a.to).append("\n");
                cont++;
            }
        }

        System.out.println(cont);
        System.out.print(str);
    }

    public static boolean connected(ArrayList<Arista>[] graph, int node, int objective, int N){
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        boolean[] visitado= new boolean[N];

        queue.offer(node);
        visitado[node] = true;

        while(!queue.isEmpty()){
            int aux = queue.poll();

            for(Arista ady: graph[aux]){
                int destiny = ady.to;
                if(!(ady.from == node && destiny == objective)){
                    if (destiny == objective)
                        return true;
                    if(!visitado[destiny]){
                        queue.offer(destiny);
                        visitado[destiny] = true;
                    }
                }
            }
        }
        return false;
    }
}