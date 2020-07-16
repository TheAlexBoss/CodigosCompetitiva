package CP20200327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class DnoTLE {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int I = Integer.parseInt(br.readLine());
        int N = 2*I+1;
        char[][] grafo = new char[N][N];
        int[][] grafo_cc = new int[I][I];

        for (int i = 0; i < N; i++) {
            String lect = br.readLine();
            for (int j = 0; j < N; j++) {
                grafo[i][j] = lect.charAt(j);
            }
        }

        int marcador = 1;

        ArrayList<Par> madres = new ArrayList<>();
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int x = Integer.parseInt(s[0]);
            int y = Integer.parseInt(s[1]);

            madres.add(new Par(x,y));
            cc(grafo_cc, grafo, marcador, x,y);
            marcador++;
        }

        int C = Integer.parseInt(br.readLine());
        for (int i = 0; i < C; i++) {
            String[] s = br.readLine().split(" ");

            Par hijo = new Par(Integer.parseInt(s[0]), Integer.parseInt(s[1]));
            Par tienda = new Par(Integer.parseInt(s[2]), Integer.parseInt(s[3]));

            cc(grafo_cc, grafo, marcador, hijo.i, hijo.j);
            marcador++;
            cc(grafo_cc, grafo, marcador, tienda.i, tienda.j);
            marcador++;

            boolean llego_tienda = grafo_cc[hijo.i][hijo.j] == grafo_cc[tienda.i][tienda.j];
            boolean llega_madre = false;
            for (int j = 0; j < M; j++) {
                Par madre = madres.get(j);
                llega_madre = grafo_cc[hijo.i][hijo.j] == grafo_cc[madre.i][madre.j];
                if(llega_madre)
                    break;
            }

            if(llega_madre)
                System.out.println("CASTIGADO SIN JUEGO");
            else
                if(llego_tienda)
                    System.out.println("CALL OF DUTY");
                else
                    System.out.println("MAL PLANEADO");
        }

    }

    static int[] movI = {-1, 0, 1, 0};
    static int[] movJ = {0, -1, 0, 1};
    public static void cc(int[][] grafo, char[][] grafoChar, int marcador, int start_x, int start_y){
        if(grafo[start_x][start_y] != 0)
            return;

        ArrayDeque<Par> cola = new ArrayDeque<>();
        cola.offer(new Par(start_x, start_y));
        grafo[start_x][start_y] = marcador;

        while(!cola.isEmpty()){
            Par par = cola.poll();

            for (int i = 0; i < 4; i++) {
                int to_i = par.i + movI[i];
                int to_j = par.j + movJ[i];

                if(to_i < grafo.length && to_j < grafo[0].length && to_i >= 0 && to_j >= 0){
                    if(grafoChar[2*to_i+1-movI[i]][2*to_j+1-movJ[i]] == ' ' && grafo[to_i][to_j]!=marcador){
                        grafo[to_i][to_j] = marcador;
                        cola.offer(new Par(to_i, to_j));
                    }
                }
            }

        }

    }

    public static void print(char[][] grafo){
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[0].length; j++) {
                System.out.print(grafo[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public static void print(int[][] grafo){
        for (int i = 0; i < grafo.length; i++) {
            for (int j = 0; j < grafo[0].length; j++) {
                System.out.print(grafo[i][j] + "\t");
            }
            System.out.println();
        }
    }


    static class Par{
        int i,j;

        public Par(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Par par = (Par) o;
            return i == par.i &&
                    j == par.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
