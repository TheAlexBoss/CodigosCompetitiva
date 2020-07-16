package clasificatoriaSWERC2018;

import java.io.*;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class G3 {
    /*static int matrix[][];
    static boolean visitados[][];
    static final int INF = Integer.parseInt("3F3F3F3F",16);

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visitados = new boolean[N][N];

        String[] str;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }

        pw.println(movimiento(N,N/2,N/2));
    }

    public static int f(int ni, int nj, int nni, int nnj){

        int N = matrix.length;


        int hn = matrix[ni][nj];
        int hnn = matrix[nni][nnj];

        int dif = Math.abs(hn - hnn);

        if(hnn > hn)
            return 500 + dif*2;

        return 500 - dif;
    }

    public static long movimiento(int N, int i, int j){
        if((i == 0 && j == 0) || (i == N-1 && j == N-1) || (i == 0 && j == N-1) || (i == N-1 && j == 0))
            return 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(4);

        if(i > 0 && !visitados[i-1][j])
            pq.offer(new Node(i-1,j,f(i,j,i-1,j)));

        if(i < N-1 && !visitados[i+1][j])
            pq.offer(new Node(i+1,j,f(i,j,i+1,j)));

        if(j > 0 && !visitados[i][j-1])
            pq.offer(new Node(i,j-1,f(i,j,i,j-1)));

        if(j < N-1 && !visitados[i][j+1])
            pq.offer(new Node(i,j+1,f(i,j,i,j+1)));


        Node node = pq.poll();
        visitados[i][j] = true;
        return movimiento(N,node.i,node.j) + node.f;
    }*/
}