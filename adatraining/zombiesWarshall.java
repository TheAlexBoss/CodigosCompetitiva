package adatraining;

import java.io.*;
import java.util.PriorityQueue;


class State implements Comparable<State>{
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

class Arista{
    int from,to,peso;

    public Arista(int from, int to, int peso) {
        this.from = from;
        this.to = to;
        this.peso = peso;
    }
}
public class zombiesWarshall {
    public static void main(String args[])throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        int[][] grafo;
        String linea;
        while((linea = br.readLine())!=null){
            String nums[] = linea.split(" ");
            int N = Integer.parseInt(nums[0]);
            int lineas = Integer.parseInt(nums[1]);
            grafo = new int[N][N];

            String str[];

            for (int i = 0; i < lineas; i++) {
                str = br.readLine().split(" ");
                int acum=0;
                for (int j = 0; j < str.length-1; j+=2) {
                    int t = Integer.parseInt(str[j+2]);
                    grafo[Integer.parseInt(str[j])-1][Integer.parseInt(str[j+2])-1] = t;
                    acum+=t;
                }
                grafo[Integer.parseInt(str[str.length-1])-1][Integer.parseInt(str[0])-1] = (60-acum);
            }

            int res = dijsktra(grafo)[N-1];

            if(res!=-1){
                pw.println(res%60);
            }else{
                pw.println("Hoy no vuelvo");
            }

        }

        pw.flush();

    }


    public static int[] dijsktra(int grafo[][]){
        int N = grafo.length;
        PriorityQueue<State> cola = new PriorityQueue<>();
        boolean visitado[] = new boolean[N];
        int distancia[] = new int[N];
        for (int i = 0; i < N; i++) {
            distancia[i]=-1;
        }

        cola.offer(new State(0,0));

        while(!cola.isEmpty()){
            State actual = cola.poll();
            for (int i = 0; i < N; i++) {
                if(grafo[actual.nodo][i]>0 && !visitado[actual.nodo]){
                    int aux = grafo[actual.nodo][i]+actual.tiempo;
                    if(distancia[i]>aux || distancia[i]== -1){
                        distancia[i] = aux;
                    }
                    cola.offer(new State(i,distancia[i]));
                }
            }
            visitado[actual.nodo] = true;
        }


        return distancia;
    }

    public static int prim(int[][] grafo){
        int N = grafo.length;
        PriorityQueue<State> cola = new PriorityQueue<>();
        boolean visitado[] = new boolean[N];
        int suma = 0;
        cola.offer(new State(0,0));

        while(!cola.isEmpty()){
            State actual = cola.poll();
            if(actual.nodo == N){
                return suma;
            }

            if(!visitado[actual.nodo]){
                suma+=actual.tiempo;
                visitado[actual.nodo] = true;

                for (int i = 0; i < N; i++) {
                    if(!visitado[i] && grafo[actual.nodo][i]>0){
                        cola.offer(new State(i,grafo[actual.nodo][i]));
                    }
                }
            }

        }

        for (int i = 0; i < N; i++) {
            if(!visitado[i]){
                suma = -1;
                break;
            }
        }
        return suma;
    }
}
