package adatraining;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Scanner;

public class antepasado {
    public static void main(String[] args) throws IOException{
        Reader scn = new Reader();

        int C = scn.nextInt();

        for (int i = 0; i < C; i++) {
            int max = scn.nextInt();
            int P = scn.nextInt();
            int[] array = new int[P];
            boolean posible = true;

            for (int j = 0; j < P; j++) {
                array[j] = scn.nextInt();
            }

            //Tamaños ventana
            ArrayDeque<Integer> stack = new ArrayDeque<>();
            int ventana = 0;
            boolean flag = true;
            for (int j = 0; j < P && flag; j++) {
                ventana += array[j];

                if(j > 0)
                    ventana++;

                if(ventana > max)
                    flag = false;

                if(flag)
                    stack.push(ventana);
            }

            stack.push(max);

            //Tamaños ventana
            int window = 0, sum, jota;
            posible = false;
            while(!stack.isEmpty() && !posible){
                sum = 0;
                jota = stack.poll();
                posible = true;
                for (int k = 0; k < P; k++) {
                    if(sum != 0)
                        sum++;
                    sum += array[k];

                    if(sum > jota){
                        posible = false;
                        break;
                    }else if(sum == jota){
                        sum = 0;
                    }
                }
                if(posible)
                    window = jota;
            }
            if(posible)
                System.out.println(window);
            else
                System.out.println("IMPOSIBLE");
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