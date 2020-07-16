package com.company;
import java.util.*;

public class SWERC2019A {
    static int INF = Integer.parseInt("3F3F3F3F",16);
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        Node home = new Node(scn.nextInt(),scn.nextInt());
        Node dest = new Node(scn.nextInt(),scn.nextInt());

        int MAX_DISTANCE = scn.nextInt();
        int CAR = scn.nextInt();

        int T = scn.nextInt();
        int[] transport = new int[T+1];
        transport[0] = CAR;

        for (int i = 1; i < T+1; i++) {
            transport[i] = scn.nextInt();
        }

        int N = scn.nextInt(), mode, connections, connect;
        ArrayList<Edge>[] graph = new ArrayList[N+2];
        Node[] translate = new Node[N+2];
        translate[0] = home;
        translate[N+1] = dest;

        for (int i = 0; i < N+2; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 1; i < N+1; i++) {
            translate[i] = new Node(scn.nextInt(), scn.nextInt());

            connections = scn.nextInt();
            for (int j = 0; j < connections; j++) {
                connect = scn.nextInt() + 1;
                mode = scn.nextInt();
                graph[i].add(new Edge(i,connect,mode));
                graph[connect].add(new Edge(connect,i,mode));
            }

            //graph[i].add(new Edge(i,0,0));
            graph[0].add(new Edge(0,i,0));
            //graph[N+1].add(new Edge(N+1,i,0));
            graph[i].add(new Edge(i,N+1,0));
        }
        graph[0].add(new Edge(0, N+1,0));

        PriorityQueue<State> queue = new PriorityQueue<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int[][] distancias = new int[N+2][2];
        for (int i = 1; i < N+2; i++) {
            Arrays.fill(distancias[i], INF);
        }

        int cost;
        queue.offer(new State(0,0,MAX_DISTANCE,-1));
        while(!queue.isEmpty()){
            State actual = queue.poll();
            stack.push(actual.node);
            if(actual.kmRemaining >= 0){
                for (Edge edge: graph[actual.node]){
                    if(edge.to != actual.previous){
                        cost = cost(edge, translate, transport);
                        int newKm = actual.kmRemaining - dist(translate[edge.from], translate[edge.to]);

                        if(distancias[edge.to][0] > cost + actual.cost && newKm >= 0){ //distancias[edge.to] = Math.min(distancias[edge.to], cost + actual.cost);
                            distancias[edge.to][1] = distancias[edge.to][0];
                            distancias[edge.to][0] = cost + actual.cost;
                        }

                        if(newKm >= 0)
                            queue.offer(new State(edge.to, distancias[edge.to][0],newKm, actual.node));
                    }
                }
            }else{
                while(!stack.isEmpty()){
                    int nodo = stack.pop();
                    distancias[nodo][0] = distancias[nodo][1];
                }
            }

        }

        if(distancias[N+1][0] == INF)
            System.out.println(-1);
        else
            System.out.println(distancias[N+1][0]);

    }

    public static int cost(Edge e, Node[] translator, int[] transport){
        return dist(translator[e.from], translator[e.to]) * transport[e.mode];
    }

    public static int dist(Node from, Node to){
        return (int) Math.ceil(Math.sqrt(Math.pow(from.x - to.x,2) + Math.pow(from.y-to.y,2)));
    }
}

class Node{
    int x, y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Edge{
    int from,to;
    int mode;

    public Edge(int x, int y, int mode) {
        this.from = x;
        this.to = y;
        this.mode = mode;
    }
}

class State implements Comparable<State>{
    int node;
    int cost;
    int kmRemaining;
    int previous;

    public State(int node, int cost, int kmRemaining, int previous) {
        this.node = node;
        this.cost = cost;
        this.kmRemaining = kmRemaining;
        this.previous = previous;
    }

    @Override
    public int compareTo(State o) {
        return this.cost-o.cost;
    }
}