package com.company;

import java.io.*;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class TIA {
    public static int MOD = 1000000007;
    public static void main(String[] args) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),false);
        Reader br = new Reader();

        int N;
        HashSet<String> set;

        while((N = Integer.parseInt(br.readLine())) != 0){

            String[] str = br.readLine().split(" ");
            set = new HashSet<>();

            for (int i = 0; i < N; i++) {
                set.add(str[i]);
            }

            str = br.readLine().split("0");
            int result = 1;

            for (int i = 0; i < str.length; i++) {
                int[][] memo = new int[str[i].length()][str[i].length()];
                for (int j = 0; j < str[i].length(); j++) {
                    Arrays.fill(memo[j], -1);
                }
                result = (result * dp(memo, str[i], set, 0, str[i].length() - 1)) % MOD;
            }

            pw.println(result);

        }
        pw.flush();
    }

    public static int dp(int[][] memo, String str, HashSet<String> set, int start, int  end){
        if(start > end){
            if(set.contains(str.substring(end,end+1)) || set.contains(str.substring(start,start+1)))
                return 1;
            return 0;
        }


        if(start >= memo.length || end < 0)
            return 0;

        if(memo[start][end] != -1)
            return memo[start][end];

        int contains = set.contains(str.substring(start,end+1)) ? 1 : 0;

        if(start == end){
            memo[start][end] = contains;
            return memo[start][end];
        }


        int T1, T2, T3;

        T1 = dp(memo, str, set, start,end-1);
        T2 = dp(memo, str, set, start+1,end);
        T3 = dp(memo, str, set, start+1,end-1);

        memo[start][end] = (T1 + T2 - T3 + contains) % MOD;

        return memo[start][end];
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
