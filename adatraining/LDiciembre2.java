package adatraining;

import java.util.ArrayList;
import java.util.Scanner;

public class LDiciembre2 {

    static class Arista{
        int from, to;

        public Arista(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public static int time, sol;
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int N = scn.nextInt(), A = scn.nextInt();
        ArrayList<Arista>[] grafo = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            grafo[i] = new ArrayList<>();
        }

        for (int i = 0; i < A; i++) {
            int from = scn.nextInt(), to = scn.nextInt();
            grafo[from].add(new Arista(from, to));
            grafo[to].add(new Arista(to, from));
        }

        System.out.println(AP(grafo, N));
    }

    // A recursive function that find articulation points using DFS
    // u --> The vertex to be visited next
    // visited[] --> keeps tract of visited vertices
    // disc[] --> Stores discovery times of visited vertices
    // parent[] --> Stores parent vertices in DFS tree
    // ap[] --> Store articulation points
    static int APUtil(ArrayList<Arista>[] adj, int u, boolean visited[], int disc[], int low[], int parent[], int ap[]){

        // Count of children in DFS Tree
        int children = 0;

        // Mark the current node as visited
        visited[u] = true;

        // Initialize discovery time and low value
        disc[u] = low[u] = ++time;

        // Go through all vertices aadjacent to this
        for (Arista arista : adj[u]) {
            int v = arista.to;  // v is current adjacent of u

            // If v is not visited yet, then make it a child of u
            // in DFS tree and recur for it
            if (!visited[v]) {
                children++;
                parent[v] = u;
                sol = APUtil(adj, v, visited, disc, low, parent, ap);

                // Check if the subtree rooted with v has a connection to
                // one of the ancestors of u
                low[u] = Math.min(low[u], low[v]);

                // u is an articulation point in following cases

                // (1) u is root of DFS tree and has two or more chilren.
                if (parent[u] == -1 && children > 1){
                    ap[u]++;
                    if((ap[u] > ap[sol]) || (ap[u] == ap[sol] && u < sol))
                        sol = u;
                }


                // (2) If u is not root and low value of one of its child
                // is more than discovery value of u.
                if (parent[u] != -1 && low[v] >= disc[u]){
                    ap[u]++;
                    if((ap[u] > ap[sol]) || (ap[u] == ap[sol] && u < sol))
                        sol = u;
                }

            }

            // Update low value of u for parent function calls.
            else if (v != parent[u])
                low[u] = Math.min(low[u], disc[v]);
        }

        return sol;
    }

    // The function to do DFS traversal. It uses recursive function APUtil()
    static int AP(ArrayList<Arista>[] grafo, int V){
        // Mark all the vertices as not visited
        boolean visited[] = new boolean[V];
        int disc[] = new int[V];
        int low[] = new int[V];
        int parent[] = new int[V];
        int ap[] = new int[V]; // To store articulation points

        // Initialize parent and visited, and ap(articulation point)
        // arrays
        for (int i = 0; i < V; i++)
        {
            parent[i] = -1;
            visited[i] = false;
            ap[i] = 0;
        }

        // Call the recursive helper function to find articulation
        // points in DFS tree rooted with vertex 'i'
        time = 0;
        sol = 0;
        int sol = 0;
        for (int i = 0; i < V; i++)
            if(!visited[i])
                sol = APUtil(grafo, i, visited, disc, low, parent, ap);

        // Now ap[] contains articulation points, print them
        return sol;
    }
}
