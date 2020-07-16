package com.company;

import java.io.*;
import java.util.Scanner;

public class spojJRIDE2 {

    public static void main(String[] args) throws IOException{
        //Scanner scn = new Scanner(System.in);
        Reader scn = new Reader();
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out), false);

        int T = scn.nextInt();

        for (int k = 1; k < T + 1; k++) {
            int B = scn.nextInt();
            int lectura = scn.nextInt();
            int[] memo = new int[B - 1];
            int max, ini = 0, fin = 0, maxIni = 0, maxFin = 0;
            memo[0] = lectura;
            max = memo[0];


            for (int i = 1; i < B - 1; i++) {
                lectura = scn.nextInt();
                if (memo[i - 1] >= 0) {
                    memo[i] = memo[i - 1] + lectura;
                    fin++;
                } else {// <
                    memo[i] = lectura;
                    ini = i;
                    fin = i;
                }

                if (memo[i] > max) {
                    max = memo[i];
                    maxIni = ini;
                    maxFin = fin;
                } else if (memo[i] == max && ((maxFin - maxIni < fin - ini) || (maxFin - maxIni == fin - ini) && (maxIni > ini))) {
                    maxIni = ini;
                    maxFin = fin;
                }
            }
            maxIni++;
            maxFin += 2;

            if (max >= 0) {
                pw.println("The nicest part of route " + k + " is between stops " + maxIni + " and " + maxFin);
            } else {
                pw.println("Route " + k + " has no nice parts");
            }
        }
        pw.flush();
    }

    public static int[] dp(int[] array) {
        int[] res = new int[3];
        int[] memo = new int[array.length];
        int max, ini = 0, fin = 0, maxIni = 0, maxFin = 0;
        memo[0] = array[0];
        max = memo[0];

        for (int i = 1; i < array.length; i++) {

            if (memo[i - 1] > 0) {
                memo[i] = memo[i - 1] + array[i];
                fin++;
            } else {// <=
                memo[i] = array[i];
                ini = i;
                fin = i;
            }

            if (memo[i] > max) {
                max = memo[i];
                maxIni = ini;
                maxFin = fin;
            } else if (memo[i] == max && ((maxFin - maxIni < fin - ini) || (maxFin - maxIni == fin - ini) && (maxIni > ini))) {
                maxIni = ini;
                maxFin = fin;
            }
        }

        for (int i = 0; i < array.length; i++) {
            System.out.println(memo[i]);
        }

        System.out.println("Max: " + max);
        System.out.println("En el intervalo (" + maxIni + " , " + maxFin + ")");
        return memo;
    }

    //Reader de Jakub
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;

        public Reader() {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public Reader(String file_name) throws IOException {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] buf = new byte[1024]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1) {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }

        public int nextInt() throws IOException {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            } while ((c = read()) >= '0' && c <= '9');

            if (neg)
                return -ret;
            return ret;
        }

        public long nextLong() throws IOException {
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

        public double nextDouble() throws IOException {
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

            if (c == '.') {
                while ((c = read()) >= '0' && c <= '9') {
                    ret += (c - '0') / (div *= 10);
                }
            }

            if (neg)
                return -ret;
            return ret;
        }

        private void fillBuffer() throws IOException {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }

        public void close() throws IOException {
            if (din == null)
                return;
            din.close();
        }
    }
}