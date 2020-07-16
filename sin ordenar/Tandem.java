package com.company;
import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Tandem {
    public static void main(String[] args) throws IOException{
        Scanner scn = new Scanner(System.in);
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), false);

        int N = 0;
        long P = 0;
        ArrayList<Long> pesos;

        N = scn.nextInt();
        P = scn.nextLong();
        while(N != 0 || P != 0){
            pesos = new ArrayList<>(N);
            int size = 0;
            for (int i = 0; i < N; i++) {
                long peso = scn.nextLong();
                if(peso <= P){
                    size++;
                    pesos.add(peso);
                }
            }
            Collections.sort(pesos);

            BigInteger parejas = BigInteger.ZERO;
            for (int i = 0; i < size; i++) {
                int j = binaryMaxIndex(pesos,P-pesos.get(i), 0, size-1);
                if (j-i > 0)
                    parejas = parejas.add(new BigInteger(String.valueOf(j-i)));
            }

            pw.println(parejas);
            N = scn.nextInt();
            P = scn.nextLong();
        }
        pw.flush();
    }

    public static int binaryMaxIndex(ArrayList<Long> array, Long elem, int low, int up){
        if(low == up)
            return up;

        if(low+1 == up)
            if(elem >= array.get(up)){
                return up;
            }else{
                return low;
            }

        int mid = (low+up)/2;

        if(elem >= array.get(mid)){
            return binaryMaxIndex(array,elem,mid,up);
        }else{
            return binaryMaxIndex(array,elem,low,mid);
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
            byte[] buf = new byte[1024]; // line length
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