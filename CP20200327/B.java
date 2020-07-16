package CP20200327;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Scanner;

public class B {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt(), M = scn.nextInt();
        int C = scn.nextInt();
        char[][] grafo = new char[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grafo[i][j] = 'O';
            }
        }

        ArrayList<Integer> init_x = new ArrayList<>();
        ArrayList<Integer> init_y = new ArrayList<>();
        for (int i = 0; i < C; i++) {
            int from_x = scn.nextInt(), from_y = scn.nextInt(), to_x = scn.nextInt(), to_y = scn.nextInt();
            init_x.add(from_x);
            init_y.add(from_y);
            for (int j = from_x; j <= to_x ; j++) {
                for (int k = from_y; k <= to_y; k++) {
                    grafo[j][k] = 'X';
                }
            }
        }

        int blancas = 0, negras = 0;
        for (int i = 0; i < C; i++) {

            int[] result = BFS(grafo, init_x.get(i), init_y.get(i));
            blancas += Math.max(result[0], result[1]);
            negras += Math.min(result[0], result[1]);
        }

        System.out.println((blancas+negras) + " " + blancas + " " + negras);
    }

    public static void print(char[][] grafo){
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[0].length; j++) {
                System.out.print(grafo[i][j] + "\t");
            }
            System.out.println();
        }
    }


    static int[] movI = {-1, 0, 1, 0};
    static int[] movJ = {0, -1, 0, 1};
    static char[] col = {'N', 'B'};
    static class Par{int i,j; int idx;
    public Par(int i, int j, int idx) { this.i = i;this.j = j; this.idx = idx;}}

    public static int[] BFS(char[][] grafo, int init_x, int init_y){
        ArrayDeque<Par> cola = new ArrayDeque<>();
        int[] c = new int[2];

        if(grafo[init_x][init_y] == 'X'){
            cola.offer(new Par(init_x, init_y, 0));
            c[0]++;
            grafo[init_x][init_y] = col[0];
        }


        while(!cola.isEmpty()){
            Par par = cola.poll();

            for (int i = 0; i < 4; i++) {
                int to_i = par.i + movI[i];
                int to_j = par.j + movJ[i];

                if(to_i < grafo.length && to_j < grafo[0].length && to_i>= 0 && to_j >= 0){
                    if(grafo[to_i][to_j] == 'X'){
                        cola.offer(new Par(to_i, to_j, (par.idx + 1)%2));
                        grafo[to_i][to_j] = col[(par.idx + 1)%2];
                        c[(par.idx + 1)%2]++;
                    }
                }
            }
        }
        return c;
    }
}
