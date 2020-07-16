package com.company;

import java.util.*;

public class limpiaParabrisas {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int D, R;
        int[] c;

        while((D=scn.nextInt()) != 0){
            R = scn.nextInt();
            c = new int[R];
            for (int i = 0; i < R; i++) {
                c[i] = scn.nextInt();
            }

            if(BFS(c, D,R))
                System.out.println("SI");
            else
                System.out.println("NO");
        }

    }

    public static boolean BFS(int[] c, int D, int R){
        LinkedList<State> queue = new LinkedList<>();
        HashSet<State> visitado = new HashSet<>();
        State aux, actual;
        int min, dif;
        int[] auxArray = new int[R];

        aux = new State(auxArray);
        queue.add(aux);
        visitado.add(aux);

        while(!queue.isEmpty()){
            actual = queue.pollFirst();

            int a = 0;

            for (int i = 0; i < R; i++) {
                if(actual.capacities[i] == D)
                    return true;
            }


            // Vaciar las jarras
            for (int i = 0; i < R; i++) {
                auxArray = actual.capacities.clone();
                aux = new State(auxArray);
                aux.capacities[i] = 0;
                if(!visitado.contains(aux)){
                    visitado.add(aux);
                    queue.add(aux);
                }
            }

            //Llenar las jarras
            for (int i = 0; i < R; i++) {
                auxArray = actual.capacities.clone();
                aux = new State(auxArray);
                aux.capacities[i] = c[i];
                if(!visitado.contains(aux)){
                    visitado.add(aux);
                    queue.add(aux);
                }
            }

            //Trasvase de Jarras
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < R; j++) {
                    if(i != j){
                        auxArray = actual.capacities.clone();
                        aux = new State(auxArray);

                        min = Math.min(aux.capacities[i] + aux.capacities[j], c[j]);
                        dif = aux.capacities[i] - min + aux.capacities[j];

                        aux.capacities[i] = dif;
                        aux.capacities[j] = min;

                        if(!visitado.contains(aux)){
                            visitado.add(aux);
                            queue.add(aux);
                        }
                    }
                }
            }
        }
        return false;

    }

    static class State{
        int[] capacities;

        public State(int[] capacities) {
            this.capacities = capacities.clone();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            State state = (State) o;
            return Arrays.equals(capacities, state.capacities);
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(capacities);
        }
    }
}
