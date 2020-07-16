package adatraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class zombies {
    static int INF = Integer.parseInt("3F3F3F3F",16);
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String lect;
        String[] lects;

        int N, L;
        int Tacumulado, inicio_linea;

        ArrayList<Arista>[] grafo;
        HashMap<Integer, HashMap<Integer, Integer>> lineasParada;
        HashMap<Integer, Integer> lineaParada;
        LinkedList<Integer> lineas_iniciales;

        while((lect = br.readLine()) != null){

            lects = lect.split(" ");
            N = Integer.parseInt(lects[0]);
            L = Integer.parseInt(lects[1]);

            grafo = new ArrayList[N+1];
            for (int i = 0; i < N+1; i++) {
                grafo[i] = new ArrayList<>();
            }

            lineasParada = new HashMap<>();
            lineas_iniciales = new LinkedList<>();

            for (int i = 0; i < L; i++) {
                lects = br.readLine().split(" ");

                Tacumulado = 0;
                inicio_linea = Integer.parseInt(lects[0]);
                lineaParada = new HashMap<>();
                lineaParada.put(inicio_linea, Tacumulado);

                if(inicio_linea == 1){
                    lineas_iniciales.add(i+1);
                }

                int tiempo, parada, from;
                for (int j = 1; j < lects.length; j+=2) {

                    tiempo = Integer.parseInt(lects[j]);
                    parada = Integer.parseInt(lects[j+1]);

                    if(parada == 1){
                        lineas_iniciales.add(i+1);
                    }

                    Tacumulado += tiempo;
                    lineaParada.put(parada, Tacumulado);

                    from = Integer.parseInt(lects[j-1]);
                    grafo[from].add(new Arista(from, parada, tiempo, i+1));
                }

                from = Integer.parseInt(lects[lects.length-1]);
                parada = Integer.parseInt(lects[0]);

                grafo[from].add(new Arista(from, parada, 60 - Tacumulado, i+1));
                lineasParada.put(i+1, lineaParada);
            }

            //DIJSKTRA
            PriorityQueue<State> cola = new PriorityQueue<>();
            long[][] esperas = new long[N+1][60];

            for (int i = 0; i < N+1; i++) {
                Arrays.fill(esperas[i], INF);
            }
            long solucion = INF;

            for(Integer linea_uni: lineas_iniciales)
                cola.offer(new State(1,0, linea_uni, 0));

            while(!cola.isEmpty()){
                State aux = cola.poll();

                if(aux.nodo == N){
                    solucion = aux.espera;
                    break;
                }

                for (Arista ady: grafo[aux.nodo]) {
                    long espera = calcEspera(lineasParada, aux.nodo, ady.linea, aux.distancia);
                    long coste = aux.distancia + ady.peso;

                    if(esperas[ady.to][(int)coste%60] > aux.espera + espera){

                        esperas[ady.to][(int)coste%60] = aux.espera + espera;
                        cola.offer(new State(ady.to, coste+espera, ady.linea, esperas[ady.to][(int)coste%60]));
                    }
                }
            }

            if(solucion == INF)
                System.out.println("Hoy no vuelvo");
            else
                System.out.println(solucion);
        }
    }

    public static long calcEspera(HashMap<Integer, HashMap<Integer, Integer>> lineas, int from, int toLinea, long T){
        long hora = T%60;
        long result = lineas.get(toLinea).get(from) - hora;
        if(result >= 0)
            return result;
        else
            return 60 + result;
    }

    static class State implements Comparable<State>{
        int nodo,linea;
        long distancia, espera;

        public State(int nodo, long distancia, int linea, long espera) {
            this.nodo = nodo;
            this.distancia = distancia;
            this.linea = linea;
            this.espera = espera;
        }

        @Override
        public int compareTo(State o) {

            if(this.espera < o.espera)
                return -1;
            else if(this.espera > o.espera)
                return 1;
            else
                return (int) (this.distancia - o.distancia);
        }
    }
    static class Arista{
        int from, to, linea;
        int peso;

        public Arista(int from, int to, int peso, int linea) {
            this.from = from;
            this.to = to;
            this.peso = peso;
            this.linea = linea;
        }
    }
}
