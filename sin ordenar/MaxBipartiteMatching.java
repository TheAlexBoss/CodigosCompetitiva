package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class MaxBipartiteMatching {

    public static void main(String[] args) throws IOException {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Reader br = new Reader();
        String line;// = br.readLine();
        //System.out.println(line);
        String[] str;// = line.split(" ");
        int N = br.nextInt(); //Integer.parseInt(str[0]);
        int M = br.nextInt(); //Integer.parseInt(str[1]);

        boolean[][] graph = new boolean[N][N];
        HashMap<String, Integer> traductor = new HashMap<>(N);
        for (int i = 0; i < N; i++) {
            line = br.readLine();
            traductor.put(line,i);
        }

        for (int i = 0; i < M; i++) {
            line = br.readLine();
            str = line.split(" ");
            graph[traductor.get(str[0])][traductor.get(str[1])] = true;
            graph[traductor.get(str[1])][traductor.get(str[0])] = true;
        }

        //Es simetrico
        System.out.println(bipartiteMatching(graph,N,N));

    }
    
    
    public static boolean findMatch(boolean[][] graph, int u, boolean[] seen, int matchR[], int N){
        for (int v = 0; v < N; v++) {
            if(graph[u][v] && !seen[v]){
                seen[v] = true;
                if(matchR[v] < 0 || findMatch(graph, matchR[v],seen, matchR, N)){
                    matchR[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    public static int bipartiteMatching(boolean[][] graph, int N, int M){
        //N: numero a la izquierda, M: numero a la derecha

        int[] matchR = new int[N];
        for(int i = 0; i < N; ++i)
            matchR[i] = -1;

        int result = 0;
        for (int u = 0; u < M; u++){
            boolean seen[] = new boolean[N];

            if (findMatch(graph, u, seen, matchR,N))
                result++;
        }
        return result;
    }



    /*public static boolean findMatch(int i, boolean[][] w, int[] mr,int[] mc,boolean[] seen){
        for (int j = 0; j < w.length; j++) {
            if(w[i][j] && !seen[j]){
                seen[j] = true;
                if(mc[j] < 0 || findMatch(mc[j],w,mr,mc,seen)){
                    mr[i] = j;
                    mc[j] = i;
                    return true;
                }
            }
        }
        return false;
    }

    public static int bipartiteMatching(boolean[][] w){
        int[] mr = new int[w.length];
        int[] mc = new int[w[0].length];

        int ct = 0;
        for (int i = 0; i < w.length; i++) {
            boolean[] seen = new boolean[w[0].length];
            if(findMatch(i,w,mr,mc,seen))
                ct++;
        }
        return ct;
    }*/
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
            byte[] buf = new byte[1024]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if(c == '\r')
                    continue;

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
