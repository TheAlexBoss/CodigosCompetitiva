package clasificatoriaSWERC2018;

import java.io.*;
import java.math.BigInteger;
import java.util.PriorityQueue;
class Node implements Comparable<Node>{
    int i,j;
    BigInteger f;

    public Node(int i, int j, BigInteger f) {
        this.i = i;
        this.j = j;
        this.f = f;
    }

    @Override
    public int compareTo(Node o) {
        return this.f.compareTo(o.f);
    }
}

public class G4 {

    static int N;
    static int matrix[][];
    static boolean visitado[][];
    static BigInteger solucion = new BigInteger("3F3F3F3F",16);

    public static void main(String[] args) throws IOException {

        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];
        visitado = new boolean[N][N];


        String[] str;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }

        pw.println(BFS(N/2,N/2));

    }

    public static BigInteger BFS(int i, int j){

        int[] movementsI = {-1, 0, 1, 0};
        int[] movementsJ = {0, -1, 0, 1};

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(i,j,BigInteger.ZERO));

        BigInteger res;

        visitado[i][j] = true;
        while(!pq.isEmpty()){
            Node node = pq.poll();
            if((node.i == 0 && node.j == 0) || (node.i == N-1 && node.j == N-1) || (node.i == 0 && node.j == N-1) || (node.i == N-1 && node.j == 0)){
                if(node.f.compareTo(solucion) < 0)
                    solucion = node.f;
            }else{
                for (int k = 0; k < 4; k++){
                    int destinyI = node.i + movementsI[k];
                    int destinyJ = node.j + movementsJ[k];

                    if(destinyI >= 0 && destinyJ >= 0 && destinyI < N && destinyJ < N){
                        res = node.f.add(f(node.i,node.j,destinyI,destinyJ));

                        if(!visitado[destinyI][destinyJ] && solucion.compareTo(res) > 0){
                            if(!((destinyI == 0 && destinyJ == 0) || (destinyI == N-1 && destinyJ == N-1) || (destinyI == 0 && destinyJ == N-1) || (destinyI == N-1 && destinyJ == 0)))
                                visitado[destinyI][destinyJ] = true;
                            pq.offer(new Node(destinyI,destinyJ,res));
                        }
                    }
                }
            }
        }
        return solucion;
    }

    public static BigInteger f(int ni, int nj, int nni, int nnj){

        int hn = matrix[ni][nj];
        int hnn = matrix[nni][nnj];

        int dif = Math.abs(hn - hnn);

        if(hnn > hn)
            return new BigInteger("" + (500 + dif*2));
        return new BigInteger("" + (500 - dif));
    }
}