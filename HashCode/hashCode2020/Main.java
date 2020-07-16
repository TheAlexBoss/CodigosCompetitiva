package hashCode2020;

import java.io.*;
import java.lang.reflect.Array;
import java.math.BigInteger;
import java.text.CollationElementIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException{
        File parentFile = new File("./src/hashCode2020/input");
        Reader reader;
        PrintWriter pw;
        for (File f: parentFile.listFiles()){
            reader = new Reader(f.getAbsolutePath());
            System.err.println("Leyendo de :" + f.getName());

            if("a".equals(f.getName().split("_")[0])){
                pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./src/hashCode2020/output/outA.txt")));
                //continue;
            }else if("b".equals(f.getName().split("_")[0])){
                pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./src/hashCode2020/output/outB.txt")));
                //continue;
            }else if("c".equals(f.getName().split("_")[0])){
                pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./src/hashCode2020/output/outC.txt")));
                //continue;
            }else if("d".equals(f.getName().split("_")[0])){
                pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./src/hashCode2020/output/outD.txt")));
                //continue;
            }else if("e".equals(f.getName().split("_")[0])){
                pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./src/hashCode2020/output/outE.txt")));
                //continue;
            }else{
                //("f".equals(f.getName().split("_")))
                pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream("./src/hashCode2020/output/outF.txt")));
                //continue;
            }

            int B = reader.nextInt(), L = reader.nextInt(), D = reader.nextInt();
            ArrayList<Book> books = new ArrayList<>(B);
            BigInteger mean = new BigInteger("0");
            for (int i = 0; i < B; i++) {
                Book daBuk = new Book(i, reader.nextInt());
                mean = mean.add(new BigInteger(Integer.toString(daBuk.score)));
                books.add(daBuk);
            }
            Collections.sort(books);

            double realMean = mean.divide(new BigInteger(Integer.toString(B))).doubleValue();

            ArrayList<Libreria> librerias = new ArrayList<>(L);
            for (int i = 0; i < L; i++) {
                int libros = reader.nextInt();
                Libreria lib = new Libreria(i, libros, reader.nextInt(), reader.nextInt());

                for (int j = 0; j < libros; j++) {
                    int id = reader.nextInt();
                    lib.addBook(id, books);
                }
                lib.calcRatio();
                librerias.add(lib);
            }
            Collections.sort(librerias);

            int scaned_libs = 0, days = 0;
            ArrayList<Libreria> finalLibs = new ArrayList<>();
            HashSet<Book> repes = new HashSet<>();

            for (int i = 0; i < librerias.size(); i++) {
                Libreria lib = librerias.get(i);
                lib.sort();
                for(Book libro_existe: lib.books){
                    if(!repes.contains(libro_existe)){
                        lib.sumNoRepe(libro_existe.score);
                    }else{
                        libro_existe.repe = true;
                    }
                }

                if(lib.meVale(realMean) && days + lib.sign_up_time < D){
                    days += lib.sign_up_time;

                    lib.sort();
                    finalLibs.add(lib);
                    for(Book b: lib.books){
                        if(days == D)
                            break;

                        scaned_libs++;
                        days++;
                        repes.add(b);
                    }
                }
            }
            /*for (int i = 0; i < librerias.size(); i++) {
                Libreria liba = librerias.get(i);
                ArrayList<Book> libos = liba.books;
                int scanned_books = 0;
                if(days + liba.sign_up_time >= D){
                    continue;
                }
                finalLibs.add(liba);
                days += liba.sign_up_time;
                for (int j = 0; j < libos.size(); j++) {
                    scanned_books++;
                    liba.scanned_books++;
                    if(scanned_books % liba.books_per_day == 0)
                        days++;

                    if(days == D){
                        break;
                    }

                }
                scaned_libs++;
                if(days >= D)
                    break;
            }*/

            pw.println(scaned_libs);
            for (int i = 0; i < scaned_libs; i++) {
                pw.println(finalLibs.get(i).id + " " +finalLibs.get(i).scanned_books);
                finalLibs.get(i).sort();
                boolean first = true;
                for (int j = 0; j < finalLibs.get(i).scanned_books; j++) {
                    if(first){
                        pw.print(finalLibs.get(i).books.get(j).id);
                        first = false;
                    }else{
                        pw.print(" " + finalLibs.get(i).books.get(j).id);
                    }
                }
                pw.println();
            }

            pw.flush();
            pw.close();
            reader.close();

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
