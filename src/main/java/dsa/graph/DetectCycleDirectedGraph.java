package dsa.graph;

import java.util.ArrayList;
/*
* Name: Detect cycle in directed graph
* Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
* */
public class DetectCycleDirectedGraph {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int V = 4;
        for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
        list.get(0).add(1);
        list.get(1).add(2);
        list.get(2).add(3);
        list.get(3).add(3);

        if (new DetectCycleDirectedGraphSolution().isCyclic(V, list))
            System.out.println("1");
        else
            System.out.println("0");

    }
}
// } Driver Code Ends


/*Complete the function below*/

class DetectCycleDirectedGraphSolution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] visited = new boolean[V];
        boolean[] inRecursion = new boolean[V];

        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                if (isCyclicDFS(i, adj, visited, inRecursion)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isCyclicDFS(int U, ArrayList<ArrayList<Integer>> adj, boolean[] visited, boolean[] inRecursion) {
        visited[U] = true;
        inRecursion[U] = true;

        for (int V : adj.get(U)) {
            if (!visited[V]) {
                if (isCyclicDFS(V, adj, visited, inRecursion)) {
                    return true;
                }
            } else if (inRecursion[V]) {
                return true;
            }
        }
        inRecursion[U] = false;
        return false;

    }
}