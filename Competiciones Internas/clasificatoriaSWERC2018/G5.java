package clasificatoriaSWERC2018;

import java.io.*;
import java.util.PriorityQueue;

public class G5 {
    static int N;
    static int matrix[][];
    static int distancias[][];
    final static int INF= Integer.parseInt("3F3F3F3F",16);
    static int solucion = INF;

    public static void main(String[] args) throws IOException {

       /* PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        distancias = new int[N][N];


        String[] str;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }

        pw.println(Math.min(Math.min(BFS(1),BFS(2)), Math.min(BFS(3),BFS(4))));*/

    }
/*
    public static int BFS(int esquina){

        int moveI;
        int moveJ;

        switch(esquina){
            case 1:
                moveI = -1;
                moveJ = -1;
                break;
            case 2:
                moveI = -1;
                moveJ = 1;
                break;
            case 3:
                moveI = 1;
                moveJ = 1;
                break;
            case 4:
                moveI = 1;
                moveJ = -1;
                break;
            default:
                moveI = 0;
                moveJ = 0;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(32);

        pq.offer(new Node(N/2,N/2,0));

        while(!pq.isEmpty()){
            Node node = pq.poll();
            //System.err.println("("+node.i+","+node.j+") -> " + node.f);

            if((node.i == 0 && node.j == 0) || (node.i == N-1 && node.j == N-1) || (node.i == 0 && node.j == N-1) || (node.i == N-1 && node.j == 0)){
                //System.err.println("\n\n("+node.i+","+node.j+") -> " + node.f + "\n\n");
                if(node.f < solucion)
                    solucion = node.f;
            }else{
                int toI = node.i + moveI;
                int toJ = node.j + moveJ;
                int resJ = node.f + f(node.i,node.j,node.i,toJ);
                int resI = node.f + f(node.i,node.j,toI,node.j);

                if(resJ<solucion){
                    pq.offer(new Node(node.i,toJ,resJ));
                }


                if(resI<solucion)
                    pq.offer(new Node(toI,node.j,resI));
            }

        }
        return solucion;
    }

    public static int f(int ni, int nj, int nni, int nnj){

        if(!(ni >= 0 && nj >= 0 && ni < N && nj < N))
            return INF;

        if(!(nni >= 0 && nnj >= 0 && nni < N && nnj < N))
            return INF;

        int hn = matrix[ni][nj];
        int hnn = matrix[nni][nnj];

        int dif = Math.abs(hn - hnn);

        if(hnn > hn)
            return 500 + dif*2;
        return 500 - dif;
    }*/
}