package CP20200327;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int I = Integer.parseInt(br.readLine());
        int N = 2*I+1;
        char[][] grafo = new char[N][N];

        for (int i = 0; i < N; i++) {
            String lect = br.readLine();
            for (int j = 0; j < N; j++) {
                grafo[i][j] = lect.charAt(j);
            }
        }

        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String[] s = br.readLine().split(" ");
            int x = 2*Integer.parseInt(s[0])+1;
            int y = 2*Integer.parseInt(s[1])+1;
            grafo[x][y] = 'M';
        }

        int C = Integer.parseInt(br.readLine());
        ArrayList<Par> hijos = new ArrayList<>(C);
        ArrayList<Par> tiendas = new ArrayList<>(C);
        for (int i = 0; i < C; i++) {
            String[] s = br.readLine().split(" ");
            hijos.add(new Par(Integer.parseInt(s[0]), Integer.parseInt(s[1])));
            tiendas.add(new Par(Integer.parseInt(s[2]), Integer.parseInt(s[3])));
        }



        for (int i = 0; i < C; i++) {

            Par hijo = hijos.get(i);
            Par tienda = tiendas.get(i);

            char ans = grafo[2 * tienda.i + 1][2 * tienda.j + 1];
            grafo[2 * tienda.i + 1][2 * tienda.j + 1] = 'T';
            boolean madre = bfs(grafo, 2*hijo.i+1, 2*hijo.j+1, N, 'M', 'T');

            if (madre){
                System.out.println("CASTIGADO SIN JUEGO");
            }else{
                boolean juego = bfs(grafo, 2*hijo.i+1, 2*hijo.j+1, N, 'T', 'M');
                if(juego)
                    System.out.println("CALL OF DUTY");
                else
                    System.out.println("MAL PLANTEADO");
            }
            grafo[2 * tienda.i + 1][2 * tienda.j + 1] = ans;
        }
    }

    static int[] movI = {-1, 0, 1, 0};
    static int[] movJ = {0, -1, 0, 1};
    public static boolean bfs(char[][] grafo, int start_x, int start_y, int N, char search, char move){
        HashSet<Par> visitado = new HashSet<>();
        ArrayDeque<Par> cola = new ArrayDeque<>();
        Par p = new Par(start_x, start_y);
        cola.offer(p);

        visitado.add(p);

        while(!cola.isEmpty()){
            Par actual = cola.poll();
            if(grafo[actual.i][actual.j] == search)
                return true;

            for (int i = 0; i < 4; i++) {
                int to_i = actual.i + movI[i];
                int to_j = actual.j + movJ[i];

                if(to_i < N && to_j < N && to_i >= 0 && to_j >= 0){
                    p = new Par(to_i, to_j);
                    if((grafo[to_i][to_j] == ' '  || grafo[to_i][to_j] == move || grafo[to_i][to_j] == search) && !visitado.contains(p)){
                        cola.offer(p);
                        visitado.add(p);
                    }
                }
            }
        }
        return false;
    }


    public static void print(char[][] grafo){
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
