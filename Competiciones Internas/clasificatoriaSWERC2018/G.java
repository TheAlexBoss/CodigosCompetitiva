package clasificatoriaSWERC2018;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;

public class G {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),true);

        int N = Integer.parseInt(br.readLine());
        String[][] alturas = new String[N][];
        for (int i = 0; i < N; i++) {
            alturas[i] = br.readLine().split(" ");
        }

        long[][] dijstra = dijsktra(alturas,N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(dijstra[i][j] + "\t\t");
            }
            System.out.println();
        }

        long aI = dijstra[0][0];
        long aD = dijstra[0][N-1];
        long abI = dijstra[N-1][0];
        long abD = dijstra[N-1][N-1];

        long min = Math.min(Math.min(aI,aD),Math.min(abI,abD));
        pw.println(min);
    }

    public static long[][] dijsktra(String[][] alturas, int N){

        PriorityQueue<State> cola = new PriorityQueue<>();
        boolean visitado[][] = new boolean[N][N];
        long[][] distancias = new long[N][N];
        int start = N/2;

        int[] node = new int[2];
        node[0] = start;
        node[1] = start;

        cola.offer(new State(node,0));

        while(!cola.isEmpty()){
            State actual = cola.poll();
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {

                    int manhattan = Math.abs(actual.nodo[0]-i) + Math.abs(actual.nodo[1]-j);

                    if(manhattan == 1 && !visitado[actual.nodo[0]][actual.nodo[1]]){
                        int dt = tiempo(alturas,actual.nodo[0],actual.nodo[1],i,j);
                        if(distancias[i][j] > dt + actual.distancia || distancias[i][j] == 0){
                            distancias[i][j] = dt + actual.distancia;
                        }

                        node = new int[2];
                        node[0] = i;
                        node[1] = j;
                        cola.offer(new State(node,distancias[i][j]));
                    }
                }
            }

            visitado[actual.nodo[0]][actual.nodo[1]] = true;

        }


        return distancias;
    }

    public static int tiempo(String[][] alturas, int x1, int x2, int y1, int y2){
        int aX = Integer.parseInt(alturas[x1][x2]);
        int aY = Integer.parseInt(alturas[y1][y2]);
        int eachMeterItHasToClimb = Math.abs(aX-aY);

        if(aX > aY){
            return 500 - eachMeterItHasToClimb;
        }else if(aX < aY){
            return 500 + eachMeterItHasToClimb*2;
        }else{
            return 0;
        }

    }
}

class State implements Comparable<State>{
    int nodo[];
    long distancia;

    public State(int[] nodo, long distancia) {
        this.nodo = nodo;
        this.distancia = distancia;
    }

    @Override
    public int compareTo(State o) {
        return Long.compare(this.distancia,o.distancia);
    }
}