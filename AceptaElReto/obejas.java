package adatraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class obejas {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        String[] str;

        while((line = br.readLine()) != null){
            str = line.split(" ");
            int M = Integer.parseInt(str[0]);
            int N = Integer.parseInt(str[1]);
            char[][] grafo = new char[N][M];

            int pto = 0, crr = 0, pto_X = 0, pto_Y = 0;

            for (int i = 0; i < N; i++) {
                line = br.readLine();
                for (int j = 0; j < line.length(); j++) {
                    grafo[i][j] = line.charAt(j);
                    if(grafo[i][j] == '.'){
                        pto++;
                        pto_X = i;
                        pto_Y = j;
                    }else if(grafo[i][j] == 'X'){
                        crr++;
                    }
                }
            }

            if(pto == BFS(grafo, pto_X, pto_Y))
                System.out.println("NO");
            else
                System.out.println("SI");
        }

    }

    static class Pair{
        int x,y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] movI = {0, 1, 0, -1};
    static int[] movJ = {1, 0, -1, 0};

    public static int BFS(char[][] grafo, int start_i, int start_j){
        ArrayDeque<Pair> cola = new ArrayDeque<>();
        boolean[][] visitado = new boolean[grafo.length][grafo[0].length];
        cola.add(new Pair(start_i, start_j));
        visitado[start_i][start_j] = true;
        int visitados = 0;

        while(!cola.isEmpty()){
            Pair p = cola.poll();
            visitados++;

            for (int i = 0; i < 4; i++) {
                int to_i = p.x+movI[i];
                int to_j = p.y+movJ[i];
                if(to_i >= 0 && to_j >= 0 && to_i < grafo.length && to_j < grafo[0].length){
                    if(!visitado[to_i][to_j] && grafo[to_i][to_j] != 'X'){
                        cola.offer(new Pair(to_i, to_j));
                        visitado[to_i][to_j] = true;
                    }

                }
            }
        }
        return visitados;
    }
}
