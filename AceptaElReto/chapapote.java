package adatraining;

import java.io.*;

public class chapapote {
    /**
     * Author: Abelian Group
     * Description: Union find structure
     */

    static int[] movI = {0, 1, 0, -1, 1, 1, -1, -1};
    static int[] movJ = {1, 0, -1, 0, 1, -1, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out));

        String line;
        String[] str;
        UnionFind uf;

        while((line = br.readLine()) != null){
            str = line.split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            int max = 0;
            char[][] grafo = new char[N][M];

            //Montamos el Union-Find
            //Vamos a hashear con la formula: M*i+j
            uf = new UnionFind((N+1)*(M+1)+4);
            uf.init();

            for (int i = 0; i < N; i++) {
                line = br.readLine();
                for (int j = 0; j < line.length(); j++) {
                    int hash = M*i+j;
                    if(line.charAt(j) == '#'){
                        // SUPER IMPORTANTE ESTE MAX -> Diferencia entre AC y WA
                        max = Math.max(max, 1);
                        // Union con los de al lado
                        if(j>0 && line.charAt(j-1) == '#'){
                            uf.connect(hash, hash-1);
                            max = Math.max(max, uf.sizeCC(hash));
                        }

                        if(j < M-1 && line.charAt(j+1) == '#'){
                            uf.connect(hash, hash+1);
                            max = Math.max(max, uf.sizeCC(hash));
                        }

                        // Union con los de arriba
                        if(i-1 >= 0){
                            if(grafo[i-1][j] == '#'){
                                uf.connect(hash, hash-M);
                                max = Math.max(max, uf.sizeCC(hash));
                            }


                            if(j>0 && grafo[i-1][j-1] == '#'){
                                uf.connect(hash, hash-M-1);
                                max = Math.max(max, uf.sizeCC(hash));
                            }


                            if(j< M-1 && grafo[i-1][j+1] == '#'){
                                uf.connect(hash, hash-M+1);
                                max = Math.max(max, uf.sizeCC(hash));
                            }

                        }
                    }
                    grafo[i][j] = line.charAt(j);
                }
            }

            int Q = Integer.parseInt(br.readLine());
            pw.print(max);

            for (int i = 0; i < Q; i++) {
                str = br.readLine().split(" ");
                int x = Integer.parseInt(str[0]) - 1;
                int y = Integer.parseInt(str[1]) - 1;
                grafo[x][y] = '#';
                int hash = M*x+y;

                // SUPER IMPORTANTE ESTE MAX -> Diferencia entre AC y WA
                max = Math.max(max, 1);
                for (int j = 0; j < 8; j++) {
                    int to_i = x + movI[j];
                    int to_j = y + movJ[j];

                    if(to_i >= 0 && to_j >= 0 && to_i < N && to_j < M){
                        if(grafo[to_i][to_j] == '#'){
                            uf.connect(hash, M*to_i+to_j);
                            max = Math.max(max, uf.sizeCC(hash));
                        }
                    }
                }
                pw.print(" " + max);
            }
            pw.println();
            pw.flush();
        }

    }

    static class UnionFind {
        /*STRUCTURE*/
        int N;

        int parent[];
        int size[];
        public UnionFind(int N){
            this.N = N;
            this.parent = new int[N];
            this.size = new int[N];
        }
        public void init(){
            for (int i = 0; i < N; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }
        public int find(int nodo){
            while(nodo!=parent[nodo]){
                nodo = parent[nodo];
            }
            return nodo;
        }
        public int getSize(int nodo){
            return this.size[nodo];
        }
        public void join(int A,int B){
            A = find(A);
            B = find(B);
            if(size[A]<size[B]){
                parent[A] = B;
                size[B]+=size[A];
            }else{
                parent[B] = A;
                size[A]+=size[B];
            }
        }
        public boolean isConnected(int A, int B){
            return (find(A) == find(B));
        }
        public int connect(int A, int B){//0 ya estaban conectados, 1 conectado correctamente
            if(isConnected(A,B)){
                return 0;
            }else{
                join(A,B);
                return 1;
            }
        }

        public int sizeCC(int A){
            A = find(A);
            return size[A];
        }
    }

    public static void printM(char[][] mat){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println();
        }

        System.out.println("=============================");
        System.out.println("=============================");
    }

    public static void printM2(char[][] mat, UnionFind uf){
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(uf.sizeCC(mat[0].length*i+j) + "\t");
            }
            System.out.println();
        }

        System.out.println("=============================");
        System.out.println("=============================");
    }

    public static void printM2(int N, int M){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                System.out.print(M*i+j + "\t");
            }
            System.out.println();
        }

        System.out.println("=============================");
        System.out.println("=============================");
    }
}