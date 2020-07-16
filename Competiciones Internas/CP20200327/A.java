package CP20200327;


import java.util.*;

public class A {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        HashMap<String, Integer> traductor = new HashMap<>();
        int V = scn.nextInt();
        ArrayList<Integer>[] grafo = new ArrayList[V];

        for (int i = 1; i < V; i++) {
            grafo[i] = new ArrayList<>();
            traductor.put(scn.next(), i);
        }

        int N = scn.nextInt();
        grafo[0] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            int to = traductor.get(scn.next());
            grafo[0].add(to);
            grafo[to].add(0);
        }

        int A = scn.nextInt();
        for (int i = 0; i < A; i++) {
            int from = traductor.get(scn.next());
            int to = traductor.get(scn.next());

            grafo[from].add(to);
            grafo[to].add(from);
        }


        if(BFS(grafo, V,0,traductor.get(scn.next())))
            System.out.println("ENCONTRE A MI PRINCIPE AZUL");
        else
            System.out.println("HELADO Y GALLETAS");

    }

    public static boolean BFS(ArrayList<Integer>[] grafo, int V, int start, int obj){
        boolean[] visiado = new boolean[V];
        ArrayDeque<Integer> cola = new ArrayDeque<>();

        cola.offer(start);
        visiado[start] = true;
        while(!cola.isEmpty()){
            int actual = cola.poll();
            if(actual == obj)
                return true;
            for(Integer i: grafo[actual]){
                if(!visiado[i]){
                    cola.offer(i);
                    visiado[i] = true;
                }

            }
        }
        return false;
    }
}
