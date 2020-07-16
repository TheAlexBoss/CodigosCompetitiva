package clasificatoriaSWERC2018;

import java.io.*;
import java.util.Arrays;

public class G2 {

    static int matrix[][];
    static final int INF = Integer.parseInt("3F3F3F3F",16);

    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), true);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        matrix = new int[N][N];

        String[] str;
        for (int i = 0; i < N; i++) {
            str = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(str[j]);
            }
        }

        pw.println(Math.min(Math.min(BFS(N,0,0,1),BFS(N,0,N-1,2)),
                        Math.min(BFS(N,N-1,N-1,3),BFS(N,N-1,0,4))));
    }

    public static int f(int ni, int nj, int nni, int nnj){
        int N = matrix.length;
        if(ni<0 || nj < 0 || nni< 0 || nnj < 0)
            return INF;

        if(ni > N-1|| nj > N-1 || nni > N-1 || nnj > N-1)
            return INF;

        int hnn = matrix[ni][nj];
        int hn = matrix[nni][nnj];

        int dif = Math.abs(hn - hnn);

        if(hnn > hn)
            return 500 + dif*2;

        return 500 - dif;
    }

    public static int BFS(int N, int i, int j, int esquina){
        //System.err.println("("+i+","+j+")");
        if((i == N/2 && j== N/2) || i > N || i< 0 || j>N||j<0)
            return 0;

        int d1, d2;
        int toI, toJ;

        switch(esquina){
            case 1:
                toI = i+1;
                toJ = j+1;
                break;
            case 2:
                toI = i+1;
                toJ = j-1;
                break;
            case 3:
                toI = i-1;
                toJ = j-1;
                break;
            case 4:
                toI = i-1;
                toJ = j+1;
                break;
            default:
                toI = i;
                toJ = j;
        }

        d1 = f(i,j,toI,j);
        d2 = f(i,j,i,toJ);

        return Math.min(BFS(N,toI,j,esquina) + d1, BFS(N, i,toJ,esquina) + d2);
    }
}
