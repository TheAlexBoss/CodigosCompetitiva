package com.company;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

        wrapper("/Users/alejandro/Downloads/swerc-testcases/birdwatching/data/secret");

    }



    public static void wrapper(String fileName) throws IOException{
        File directory = new File(fileName);

        File[] files = directory.listFiles();
        Arrays.sort(files);


        for (File f: files){
            if(f.getName().contains(".in")){

                String sol = "";
                for (File fi: files)
                    if(fi.getName().contains(f.getName().substring(0,f.getName().length()-3)) && fi.getName().contains(".ans")){
                        BufferedReader br = new BufferedReader(new FileReader(fi));
                        sol = br.readLine();
                    }

                long TInicio, TFin, tiempo; //Variables para determinar el tiempo de ejecución
                TInicio = System.currentTimeMillis();

                ejecuta(f);

                System.out.println("Solución: " + sol);

                TFin = System.currentTimeMillis(); //Tomamos la hora en que finalizó el algoritmo y la almacenamos en la variable T
                tiempo = TFin - TInicio; //Calculamos los milisegundos de diferencia
                System.out.println("Tiempo de ejecución en segundos: " + (double) tiempo/1000);
            }
        }
    }



    public static void ejecuta(File file) throws FileNotFoundException {
        Scanner scn = new Scanner(new InputStreamReader(new FileInputStream(file)));

        int N = scn.nextInt(), M = scn.nextInt();

        ArrayList<Arista>[] graph = new ArrayList[N];

        for (int i = 0; i < N; i++)
            graph[i] = new ArrayList<>();

        int node = scn.nextInt();

        for (int i = 0; i < M; i++) {
            int from = scn.nextInt(), to = scn.nextInt();
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