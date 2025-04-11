package dsa.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
 * Name: 133. Clone Graph
 * Link :  https://leetcode.com/problems/clone-graph/description/
 * */


class CloneGraph {
    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        return clone(node, new HashMap<>());
    }

    private Node clone(Node node, HashMap<Node, Node> visited) {
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        Node newNode = new Node(node.val);
        visited.put(node, newNode);
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(clone(neighbor, visited));
        }
        return newNode;
    }
}

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