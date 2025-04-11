package dsa.stack;

import java.util.*;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    //DFS
    public Node cloneGraphDFS(Node node) {
        Map<Node, Node> map = new HashMap<>();
        return cloneGraphDFS(node, map);
    }

    public Node cloneGraphDFS(Node node, Map<Node, Node> map) {
        if (node == null) {
            return null;
        }
        if (map.containsKey(node)) {
            return map.get(node);
        }
        Node root = new Node(node.val);
        map.put(node, root);
        for (Node nb : node.neighbors) {
            root.neighbors.add(cloneGraphDFS(nb, map));
        }
        return root;
    }

    //BFS
    public Node cloneGraphBFS(Node node) {
        if (node == null) {
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val));
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            for (Node nb : current.neighbors) {
                if (!map.containsKey(nb)) {
                    map.put(nb, new Node(nb.val));
                    queue.add(nb);
                }
                map.get(current).neighbors.add(map.get(nb));
            }
        }
        return map.get(node);
    }
}
