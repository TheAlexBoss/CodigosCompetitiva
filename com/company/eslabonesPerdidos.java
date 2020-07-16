package com.company;

import java.util.Scanner;

public class eslabonesPerdidos {


    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N, R, from, to;
        UnionFind uf;

        while((N = scn.nextInt())!= 0){
            R = scn.nextInt();
            uf = new UnionFind(N);
            uf.init();

            int cc = N;

            for (int i = 0; i < R; i++) {
                from = scn.nextInt()-1;
                to = scn.nextInt()-1;

                if(uf.connect(from, to) == 1){
                    cc--;
                }
            }

            if(cc == 1)
                System.out.println("TODAS");
            else
                System.out.println("FALTA ALGUNA");
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
                size[i] =1;
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
    }
    class Arista implements Comparable<Arista>{
        int from,to,peso;
        public Arista(int from, int to, int peso) {
            this.from = from;
            this.to = to;
            this.peso = peso;
        }
        @Override
        public int compareTo(Arista o) {
            return this.peso-o.peso;
        }
        @Override
        public String toString(){
            return "[" + this.from + "->" + this.to +"||"+ this.peso + "]";
        }
    }
}
