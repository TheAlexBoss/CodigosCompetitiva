package adatraining;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Simetria {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] hoja;
        String input;
        String[] str;
        int start_i = -1, start_j = -1;

        while((input = br.readLine()) != null){
            str = input.split(" ");
            int h = Integer.parseInt(str[0]), v = Integer.parseInt(str[1]);
            hoja = new char[v][h];
            int nodes_to_visit = 0;

            for (int i = 0; i < v; i++) {
                input = br.readLine();
                for (int j = 0; j < h; j++) {
                    hoja[i][j] = input.charAt(j);
                    if(hoja[i][j] == 'X'){
                        nodes_to_visit++;
                        start_i = i;
                        start_j = j;
                    }

                }
            }

            //Tenemos mapeada la hoja
            if (BFS(hoja, nodes_to_visit, start_i, start_j)) {
                if (isSimetric(true, hoja) && isSimetric(false, hoja)) {
                    System.out.println("CORRECTO");
                }else {
                    System.out.println("TRAMPOSO");
                }
            }else {
                System.out.println("TRAMPOSO");
            }
        }
    }


    static class Pair{
        int i,j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static int[] movI = {1, 0, -1, 0};
    static int[] movJ = {0, 1, 0, -1};

    public static boolean BFS(char[][] map, int visit, int start_i, int start_j){
        ArrayDeque<Pair> cola = new ArrayDeque<>();
        boolean[][] visitado = new boolean[map.length][map[0].length];
        int visited = 1;


        cola.offer(new Pair(start_i, start_j));
        visitado[start_i][start_j] = true;

        while(!cola.isEmpty()){
            Pair current = cola.poll();

            for (int i = 0; i < 4; i++) {
                int toI = current.i + movI[i];
                int toJ = current.j + movJ[i];

                if(toI < map.length && toJ < map[0].length && toI >= 0 && toJ >= 0 && map[toI][toJ] == 'X' && !visitado[toI][toJ]){
                    visitado[toI][toJ] = true;
                    visited++;
                    cola.offer(new Pair(toI, toJ));
                }
            }
        }
        return visit == visited;
    }

    public static boolean isSimetric(boolean eje, char[][] map){
        // TRUE: sobre el vertical, FALSE: sobre el horizontal
        boolean isSimetric = true;
        int i,j;

        if(eje){
            i = 0;
            j = map[0].length-1;
            while(i < j){
                for (int k = 0; k < map.length && isSimetric; k++) {
                    isSimetric = (map[k][i] == map[k][j]);
                }

                i++;
                j--;
            }
        }else{
            i = 0;
            j = map.length-1;
            while(i < j){
                for (int k = 0; k < map[0].length && isSimetric; k++) {
                    isSimetric = (map[i][k] == map[j][k]);
                }

                i++;
                j--;
            }
        }

        return isSimetric;
    }
}
