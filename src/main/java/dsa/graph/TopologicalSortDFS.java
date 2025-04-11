package dsa.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSortDFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int V = 4;
        for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
        list.get(0).add(1);
        list.get(1).add(2);
        list.get(2).add(3);
        list.get(3).add(3);

        System.out.println((TopologicalSortDFSSolution.topologicalSort(list)));
    }
}

class TopologicalSortDFSSolution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                topologicalSortDFS(i, adj, visited, stack);
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private static void topologicalSortDFS(int U, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[U] = true;

        for (int V : adj.get(U)) {
            if (!visited[V]) {
                topologicalSortDFS(V, adj, visited, stack);
            }
        }
        stack.push(U);
    }
}