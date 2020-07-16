package clasificatoriaSWERC2018;

import java.io.*;
import java.util.PriorityQueue;

public class Gbfs {
    static int N;
    static int matrix[][];
    static boolean visitado[][];
    static int solucion = Integer.parseInt("3F3F3F3F",16);
    static int c = 0;

    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visitado = new boolean[N][N];
        PriorityQueue<Aux> pq = new PriorityQueue<>(N*N);


        String[] str;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }

        pq.offer(new Aux(N/2,N/2,0));
        pw.println(BFSCustom(pq));
    }


    public static int f(int ni, int nj, int nni, int nnj){

        int hn = matrix[ni][nj];
        int hnn = matrix[nni][nnj];

        int dif = Math.abs(hn - hnn);

        if(hnn > hn)
            return 500 + dif*2;
        return 500 - dif;
    }

    public static int BFSCustom(PriorityQueue<Aux> pq){

        if(pq.isEmpty())
            return 0;

        Aux aux = pq.poll();
        int i = aux.i;
        int j = aux.j;
        int acumulado = aux.distanciaAcumulada;

        System.err.println(c+" ("+i+","+j+") -> " + acumulado);
        c++;

        if((i == 0 && j == 0) || (i == N-1 && j == N-1) || (i == 0 && j == N-1) || (i == N-1 && j == 0)){
            solucion = acumulado;
            System.err.println("\n\nSOLUCION ENCONTRADA: "+ solucion);
            return solucion;
        }

        if(i > 0 && !visitado[i-1][j]){
            int acf1 = acumulado + f(i,j,i-1,j);
            if(acf1 < solucion)
                pq.offer(new Aux(i-1,j,acf1));
        }

        if(i < N-1 && !visitado[i+1][j]){
            int acf2 = acumulado + f(i,j,i+1,j);
            if(acf2 < solucion)
                pq.offer(new Aux(i+1,j,acf2));
        }

        if(j > 0 && !visitado[i][j-1]){
            int acf3 = acumulado + f(i,j,i,j-1);
            if(acf3 < solucion)
                pq.offer(new Aux(i,j-1,acf3));
        }

        if(j < N-1 && !visitado[i][j+1]){
            int acf4 = acumulado + f(i,j,i,j+1);
            if(acf4 < solucion)
                pq.offer(new Aux(i,j+1,acf4));
        }

        visitado[i][j] = true;

        return BFSCustom(pq);
    }
}

class Aux implements Comparable<Aux>{
    int i,j;
    int distanciaAcumulada;

    public Aux(int i, int j, int distanciaAcumulada) {
        this.i = i;
        this.j = j;
        this.distanciaAcumulada = distanciaAcumulada;
    }

    @Override
    public int compareTo(Aux o) {
        return this.distanciaAcumulada - o.distanciaAcumulada;
    }
}