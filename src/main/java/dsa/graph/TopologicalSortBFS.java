package dsa.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSortBFS {
    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int V = 4;
        for (int i = 0; i < V; i++) list.add(i, new ArrayList<Integer>());
        list.get(0).add(1);
        list.get(1).add(2);
        list.get(2).add(3);
        list.get(3).add(3);

        System.out.println((TopologicalSortBFSSolution.topologicalSort(list)));
    }

}

class TopologicalSortBFSSolution {
    // Function to return list containing vertices in Topological order.
    static ArrayList<Integer> topologicalSort(ArrayList<ArrayList<Integer>> adj) {
        Queue<Integer> queue = new LinkedList<>();
        int V = adj.size();

        int[] indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int u : adj.get(i)) {
                indegree[u]++;
            }
        }

        //add into queue if indegree is zero
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> res = new ArrayList<>();
        while (!queue.isEmpty()) {
            int u = queue.poll();
            res.add(u);

            for (int v : adj.get(u)) {
                indegree[v]--;
                if (indegree[v] == 0) {
                    queue.add(v);
                }
            }

        }
        return res;
    }
}
