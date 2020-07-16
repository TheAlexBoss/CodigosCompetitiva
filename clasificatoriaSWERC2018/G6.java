package clasificatoriaSWERC2018;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class Nodo implements Comparable<Nodo>{
    int i, j;
    int f;

    public Nodo(int a, int b, int dist) {
        this.i = a;
        this.j = b;
        this.f = dist;
    }

    @Override
    public int compareTo(Nodo o) {
        return this.f - o.f;
    }
}

public class G6 {
    static final int INF = Integer.parseInt("3F3F3F3F",16);
    static int[] movementsI = {-1, 0, 1, 0};
    static int[] movementsJ = {0, -1, 0, 1};
    static int[][] matrix;
    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), true);
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int[][] distancias = new int[N][N];
        matrix = new int[N][N];
        int solucion = INF;
        PriorityQueue<Nodo> pq = new PriorityQueue<>(N);

        int input;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                input = scanner.nextInt();
                matrix[i][j] = input;
            }
            Arrays.fill(distancias[i], INF);
        }

        pq.offer(new Nodo(N/2,N/2,0));
        distancias[N/2][N/2] = 0;

        while(!pq.isEmpty()){
            Nodo nodo = pq.poll();
            if((nodo.i == 0 && nodo.j == 0) || (nodo.i == N-1 && nodo.j == N-1) || (nodo.i == 0 && nodo.j == N-1) || (nodo.i == N-1 && nodo.j == 0)) {
                solucion = Math.min(nodo.f, solucion);
            }else{
                if(nodo.f < solucion)
                    for (int i = 0; i < 4; i++) {
                        int toI = nodo.i + movementsI[i];
                        int toJ = nodo.j + movementsJ[i];
                        if(toI >= 0 && toJ >= 0 && toI < N && toJ < N) {
                            int solucionParcial = nodo.f +f(nodo.i, nodo.j, toI, toJ);
                            if (solucionParcial < solucion && solucionParcial < distancias[toI][toJ]) {
                                distancias[toI][toJ] = solucionParcial;
                                pq.offer(new Nodo(toI, toJ, solucionParcial));
                            }
                        }
                    }
            }
        }
        pw.println(solucion);
    }

    public static int f(int ni, int nj, int nni, int nnj){

        int hn = matrix[ni][nj];
        int hnn = matrix[nni][nnj];

        int dif = Math.abs(hn - hnn);

        if(hnn > hn)
            return 500 + dif*2;
        return 500 - dif;
    }

}
