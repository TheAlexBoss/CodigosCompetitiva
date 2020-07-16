package adatraining;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class jardinLove {

    static class Point{
        int x,y;
        int d_acum;

        public Point(int x, int y, int d_acum) {
            this.x = x;
            this.y = y;
            this.d_acum = d_acum;
        }

        public Point(int x, int y) {
            this(x,y,0);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x &&
                    y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }


    public static void main(String[] args) throws IOException{
        //Scanner scn = new Scanner(System.in);
        Reader scn = new Reader();

        int T = scn.nextInt();

        for (int i = 0; i < T; i++) {
            int M = scn.nextInt(), N = scn.nextInt();
            char[][] grafo = new char[N][M];
            String lect;

            int start_i = 0, start_j = 0, end_i = 0, end_j = 0;
            LinkedList<Point> point_list = new LinkedList<>();


            for (int j = 0; j < N; j++) {
                lect = scn.readLine();
                for (int k = 0; k < M; k++) {
                    char item = lect.charAt(k);
                    if(item == 'P'){
                        end_i = j;
                        end_j = k;
                    }else if(item == 'E'){
                        start_i = j;
                        start_j = k;
                    }else if(item != '#' && item != '.'){
                        point_list.add(new Point(j,k));
                    }
                    grafo[j][k] = item;
                }
            }

            for(Point p: point_list){
                int n = grafo[p.x][p.y] - 48;
                grafo[p.x][p.y] = '#';
                boolean up= true, down= true, left = true, right = true;
                for (int l = 1; l <= n; l++) {
                    if(p.x-l >= 0 && up){
                        up = grafo[p.x-l][p.y] != '#';
                        grafo[p.x-l][p.y] = '#';
                    }
                    if(p.x+l < N && down){
                        down = grafo[p.x+l][p.y] != '#';
                        grafo[p.x+l][p.y] = '#';
                    }
                    if(p.y-l >= 0 && left){
                        left = grafo[p.x][p.y-l] != '#';
                        grafo[p.x][p.y-l] = '#';
                    }
                    if(p.y+l < M && right){
                        right = grafo[p.x][p.y+l] != '#';
                        grafo[p.x][p.y+l] = '#';
                    }
                }
            }

            // Grafo montado

            //printM(N,M, grafo);
            int sol = BFS(grafo, start_i, start_j, end_i, end_j);
            if(sol != Integer.MAX_VALUE)
                System.out.println(sol);
            else
                System.out.println("NO");
        }

    }

    public static int BFS(char[][] grafo, int start_x, int start_y, int fin_x, int fin_y){
        if(grafo[start_x][start_y] == '#' || grafo[fin_x][fin_y] ==  '#')
            return Integer.MAX_VALUE;

        HashSet<Point> visitado = new HashSet<>();
        ArrayDeque<Point> cola = new ArrayDeque<>();
        int N = grafo.length, M = grafo[0].length;
        int solucion = Integer.MAX_VALUE;

        cola.offer(new Point(start_x, start_y));
        Point actual, to;

        while(!cola.isEmpty()){
            actual = cola.poll();

            if(actual.x == fin_x && actual.y == fin_y)
                solucion =  actual.d_acum;


            if(actual.d_acum < solucion){
                if(actual.x - 1 >= 0 && grafo[actual.x - 1][actual.y] != '#'){
                    to = new Point(actual.x-1, actual.y, actual.d_acum + 1);
                    if(!visitado.contains(to)){
                        visitado.add(to);
                        if(to.x == fin_x && to.y == fin_y)
                            solucion =  to.d_acum;
                        else
                            cola.offer(to);
                    }
                }


                if(actual.x + 1 < N && grafo[actual.x + 1][actual.y] != '#'){
                    to = new Point(actual.x + 1, actual.y,actual.d_acum + 1);
                    if(!visitado.contains(to)){
                        visitado.add(to);
                        if(to.x == fin_x && to.y == fin_y)
                            solucion =  to.d_acum;
                        else
                            cola.offer(to);
                    }
                }

                if(actual.y - 1 >= 0 && grafo[actual.x][actual.y - 1] != '#'){
                    to = new Point(actual.x, actual.y - 1,actual.d_acum + 1);
                    if(!visitado.contains(to)){
                        visitado.add(to);
                        if(to.x == fin_x && to.y == fin_y)
                            solucion =  to.d_acum;
                        else
                            cola.offer(to);
                    }
                }

                if(actual.y + 1 < M && grafo[actual.x][actual.y + 1] != '#'){
                    to = new Point(actual.x, actual.y + 1,actual.d_acum + 1);
                    if(!visitado.contains(to)){
                        visitado.add(to);
                        if(to.x == fin_x && to.y == fin_y)
                            solucion =  to.d_acum;
                        else
                            cola.offer(to);
                    }
                }
            }

        }
        return solucion;
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
