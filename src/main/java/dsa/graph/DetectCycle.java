package dsa.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DetectCycle {
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!visited[i] && dfs(i, adj, visited, -1)) {
                return true;
            }
        }
        return false;
    }

    private boolean dfs(int U, ArrayList<ArrayList<Integer>> adj, boolean[] visited, int parent) {
        visited[U] = true;
        for (int V : adj.get(U)) {
            if (V == parent) {
                continue;
            }
            if (visited[V]) {
                return true;
            }
            if (dfs(V, adj, visited, U)) {
                return true;
            }
        }
        return false;
    }
}

class DriverClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // int t = sc.nextInt();

        //   while (t-- > 0) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int V = sc.nextInt();
        int E = sc.nextInt();
        for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
        for (int i = 0; i < E; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            list.get(u).add(v);
        }
        if (new DetectCycle().isCyclic(V, list))
            System.out.println("1");
        else
            System.out.println("0");
        System.out.println("~");

    }
// }
}