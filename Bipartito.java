//Grafos Bipartitos [VERSION AC]
// https://www.aceptaelreto.com/problem/statement.php?id=279

package GRAFOS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

class State{
    int nodo;
    char color;

    public State(int nodo, char color) {
        this.nodo = nodo;
        this.color = color;
    }
}

class Arista{
    int from,to,peso;

    public Arista(int from, int to, int peso) {
        this.from = from;
        this.to = to;
        this.peso = peso;
    }
}

public class Bipartito {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),true);

        ArrayList<Arista> grafo[];

        String linea;
        while((linea = br.readLine())!=null){
            int N = Integer.parseInt(linea);
            int M = Integer.parseInt(br.readLine());
            grafo = new ArrayList[N];

            if(M!=0){
                for (int i = 0; i < N; i++) {
                    grafo[i] = new ArrayList<>();
                }

                for (int i = 0; i < M; i++) {
                    String str[] = br.readLine().split(" ");

                    int from = Integer.parseInt(str[0]);
                    int to = Integer.parseInt(str[1]);

                    grafo[from].add(new Arista(from,to,1));
                    grafo[to].add(new Arista(to,from,1));

                }

                if(cc(grafo,N)){
                    pw.println("SI");
                }else{
                    pw.println("NO");
                }
            }else{
                pw.println("SI");
            }

        }


    }


    public static boolean cc(ArrayList<Arista>[] grafo,int N){
        boolean visitado[] = new boolean[N];
        char colores[] = new char[N];
        boolean sePuede = true;

        int i = 0;
        while (i < N && sePuede) {
            if(!visitado[i]){
                sePuede = BFS(grafo,i,visitado,colores);
            }
            i++;
        }
        return sePuede;

    }

    public static boolean BFS(ArrayList<Arista>[] grafo,int inicio,boolean[] visitado,char[] color){
        ArrayDeque<State> cola = new ArrayDeque<>();
        boolean sePuede = true;

        cola.offer(new State(inicio,'A'));
        color[inicio] = 'A';
        visitado[inicio] = true;

        while(!cola.isEmpty() && sePuede){
            State actual = cola.poll();
            if(actual.color == 'A'){
                for (Arista arista: grafo[actual.nodo]){
                    if(color[arista.to] == 'A'){
                        sePuede = false;
                        break;
                    }
                    if(!visitado[arista.to]){
                        color[arista.to] = 'N';
                        cola.offer(new State(arista.to,'N'));
                        visitado[arista.to] = true;
                    }
                }
            }else{
                for (Arista arista: grafo[actual.nodo]){
                    if(color[arista.to] == 'N'){
                        sePuede = false;
                        break;
                    }
                    if(!visitado[arista.to]){
                        color[arista.to] = 'A';
                        cola.offer(new State(arista.to,'A'));
                        visitado[arista.to] = true;
                    }

                }
            }

        }
        return sePuede;
    }
}

---------------------------------------------------------------------------------------------------------------------------------------
---------------------------------------------------------------------------------------------------------------------------------------

//Grafo bipartito [VERSION WA/TIMELIMIT]
// https://www.aceptaelreto.com/problem/statement.php?id=279

package GRAFOS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;

class State{
    int nodo;
    char color;

    public State(int nodo, char color) {
        this.nodo = nodo;
        this.color = color;
    }
}

class Arista{
    int from,to,peso;

    public Arista(int from, int to, int peso) {
        this.from = from;
        this.to = to;
        this.peso = peso;
    }
}

public class Bipartito {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(System.out),true);

        ArrayList<Arista> grafo[];

        String linea;
        while((linea = br.readLine())!=null){
            int N = Integer.parseInt(linea);
            int M = Integer.parseInt(br.readLine());
            grafo = new ArrayList[N];

            for (int i = 0; i < N; i++) {
                grafo[i] = new ArrayList<>();
            }

            for (int i = 0; i < M; i++) {
                String str[] = br.readLine().split(" ");

                int from = Integer.parseInt(str[0]);
                int to = Integer.parseInt(str[1]);

                grafo[from].add(new Arista(from,to,1));
                grafo[to].add(new Arista(to,from,1));

            }

            if(BFS(grafo,N)){
                pw.println("SI");
            }else{
                pw.println("NO");
            }
        }


    }



    public static boolean BFS(ArrayList<Arista>[] grafo,int N){
        ArrayDeque<State> cola = new ArrayDeque<>();
        boolean naranja[] = new boolean[N];
        boolean azul[] = new boolean[N];
        boolean sePuede = true;

        cola.offer(new State(0,'A'));
        azul[0] = true;

        while(!cola.isEmpty() && sePuede){
            State actual = cola.poll();
            if(actual.color == 'A'){
                for (Arista arista: grafo[actual.nodo]){
                    if(!naranja[arista.to]){
                        cola.offer(new State(arista.to,'N'));
                        naranja[arista.to] = true;
                        if(azul[arista.to] && naranja[arista.to]){
                            sePuede = false;
                            break;
                        }
                    }
                }
            }else{
                for (Arista arista: grafo[actual.nodo]){
                    if(!azul[arista.to]){
                        cola.offer(new State(arista.to,'A'));
                        azul[arista.to] = true;

                        if(azul[arista.to] && naranja[arista.to]){
                            sePuede = false;
                            break;
                        }
                    }
                }
            }


        }
        if(!sePuede){
            return false;
        }

        for (int i = 0; i < N; i++) {
            sePuede = (azul[i] || naranja[i]);
        }
        return sePuede;
    }
}
