package adatraining;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;

public class jardinLove2 {

    final static int INF = Integer.parseInt("3F3F3F3F",16);
    static int sol = INF;
    final static int[] aX = {1, 0, -1, 0};
    final static int[] aY = {0, 1, 0, -1};

    public static int bfs(int iniciox, int inicioy, int finlabx, int finlaby, boolean[][] visitado, char[][] grafo, int N, int M){
        int x,y;
        ArrayDeque<State> q = new ArrayDeque<>();
        visitado[iniciox][inicioy] = true;
        if(grafo[iniciox][inicioy]=='D' ||grafo[finlabx][finlaby]=='D') return sol;
        State p = new State(iniciox, inicioy, 1);
        q.offer(p);

        while(!q.isEmpty())
        {
            p = q.poll();
            for(int i=0; i<4; i++)
            {
                x = aX[i]+p.from;
                y = aY[i]+p.to;
                if( x>=0 && x<N && y>=0 && y<M && (grafo[x][y]=='.'||grafo[x][y]=='P') &&p.distancia<sol)
                {
                    if(!visitado[x][y])
                    {
                        visitado[x][y]=true;
                        if(grafo[x][y]=='P')
                        {
                            sol=p.distancia;
                        }
                        else
                        {
                            q.offer(new State(x,y,p.distancia+1));
                        }
                    }
                }
            }
        }
        return sol;
    }

    public static void main(String[] args) throws IOException{
        Reader reader = new Reader();
        String lect;

        int T = reader.nextInt();

        for (int i = 0; i < T; i++) {
            sol = INF;
            int M = reader.nextInt(), N = reader.nextInt();
            int ini_x = 0, ini_y= 0, fin_x=0, fin_y=0;
            boolean[][] visitado = new boolean[N][M];
            char[][] grafo = new char[N][M];

            for (int j = 0; j < N; j++) {
                lect = reader.readLine();
                for (int k = 0; k < M; k++) {
                    char mander = lect.charAt(k);
                    if(mander == 'E'){
                        ini_x = j;
                        ini_y = k;
                    }else if(mander == 'P'){
                        fin_x = j;
                        fin_y = k;
                    }
                    grafo[j][k] = mander;
                }
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    char mander = grafo[j][k];
                    if(mander >= '0' && mander <= '9'){
                        grafo[j][k] = mander;
                        for(int m=1; m<=(mander-48)&&(m+j)<N;m++) //Poner hacia derecha
                            if(grafo[m+j][k]=='#') break;
                            else if(!(grafo[j+m][k]<='9' && grafo[j+m][k]>'0')) grafo[m+j][k]='D';
                        for(int p=1; p<=(mander-48)&&(p+k)<M;p++) //Poner hacia abajo
                            if(grafo[j][p+k]=='#') break;
                            else if(!(grafo[j][p+k]<='9' && grafo[j][p+k]>'0')) grafo[j][p+k]='D';
                        for(int m=1; m<=(mander-48)&&(j-m)>-1;m++) //Poner hacia izquierda
                            if(grafo[j-m][k]=='#') break;
                            else if(!(grafo[j-m][k]<='9' && grafo[j-m][k]>'0')) grafo[j-m][k]='D';
                        for(int p=1; p<=(mander-48)&&(k-p)>-1;p++) //Poner hacia arriba
                            if(grafo[j][k-p]=='#') break;
                            else if(!(grafo[j][k-p]<='9' && grafo[j][k-p]>'0')) grafo[j][k-p]='D';

                    }
                }
            }

            //printM(N,M,grafo);
            if(bfs(ini_x,ini_y, fin_x, fin_y, visitado, grafo, N,M)!=INF)
                System.out.println(sol);
            else
                System.out.println("NO");
        }
    }

    public static void printM(int N, int M, char[][] mat){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static class State{
        int from, to, distancia;

        public State(int from, int to, int distancia) {
            this.from = from;
            this.to = to;
            this.distancia = distancia;
        }
    }

    //Reader de Jakub
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException
        {
            byte[] buf = new byte[8192]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }

        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();

            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');

            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
}
