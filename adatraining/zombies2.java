package adatraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class zombies2 {

    static int INF = Integer.parseInt("3F3F3F3F",16);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N, L;
        ArrayList<Arista>[] grafo;
        HashSet<Integer> tiempos;

        int from, to, tiempo, tAcumulado;
        String lect, lects[];


        while((lect = br.readLine()) != null && !lect.equals("")){
            lects = lect.split(" ");
            N = Integer.parseInt(lects[0]);
            L = Integer.parseInt(lects[1]);

            grafo = new ArrayList[N+1];
            tiempos = new HashSet<>();
            tiempos.add(0);
            for (int i = 0; i < N+1; i++) {
                grafo[i] = new ArrayList<>();
            }

            for (int j = 0; j < L; j++) {
                lects = br.readLine().split(" ");

                tAcumulado = 0;
                for (int i = 0; i < lects.length-2; i+=2) {
                    from = Integer.parseInt(lects[i]);
                    tiempo = Integer.parseInt(lects[i+1]);
                    to = Integer.parseInt(lects[i+2]);

                    grafo[from].add(new Arista(from, to, tiempo,tAcumulado));

                    if(from == 1)
                        tiempos.add(tAcumulado);

                    tAcumulado += tiempo;
                }
                from = Integer.parseInt(lects[lects.length-1]);
                tiempo = 60-tAcumulado;
                to = Integer.parseInt(lects[0]);

                if(from == 1)
                    tiempos.add(tAcumulado);

                grafo[from].add(new Arista(from, to, tiempo,tAcumulado));
            }

            int res = dijsktra(grafo, tiempos, 1, N);

            if(res == INF)
                System.out.println("Hoy no vuelvo");
            else
                System.out.println(res);

        }


    }
    public static int dijsktra(ArrayList<Arista>[] grafo, HashSet<Integer> tiempos, int init, int end){

        PriorityQueue<State> queue = new PriorityQueue<>();
        int[][] espera = new int[grafo.length][60];
        for (int i = 0; i < grafo.length; i++) {
            Arrays.fill(espera[i], INF);
        }

        for(Integer t: tiempos)
            queue.offer(new State(init, t, 0));

        while(!queue.isEmpty()){
            State actual = queue.poll();

            if(actual.nodo == end)
                return actual.espera;

            for (Arista ady: grafo[actual.nodo]) {
                int espera_to, distancia_to;
                espera_to = calcEspera(ady.llegada_in_hora, actual.distancia%60);
                distancia_to = actual.distancia + ady.peso + espera_to;
                if(espera[ady.to][distancia_to%60] > actual.espera + espera_to){
                    espera[ady.to][distancia_to%60] = actual.espera + espera_to;
                    queue.offer(new State(ady.to, distancia_to, espera[ady.to][distancia_to%60]));
                }
            }

        }

        return INF;
    }

    public static int calcEspera(int a, int b){
        int res = a-b;
        return res >= 0 ? res : 60+res;
    }


    static class Arista{
        int from, to, peso, llegada_in_hora;

        public Arista(int from, int to, int peso, int llegada_in_hora) {
            this.from = from;
            this.to = to;
            this.peso = peso;
            this.llegada_in_hora = llegada_in_hora;
        }
    }

    static class State implements Comparable<State>{
        int nodo, distancia, espera;

        public State(int nodo, int distancia, int espera) {
            this.nodo = nodo;
            this.distancia = distancia;
            this.espera = espera;
        }

        @Override
        public int compareTo(State o) {
            if(this.espera == o.espera)
                return this.distancia-o.distancia;
            return this.espera-o.espera;
        }
    }

}
