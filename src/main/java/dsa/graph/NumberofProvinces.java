package dsa.graph;

import java.util.*;

public class NumberofProvinces {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] isConnected = new int[4][4];

        int[] a = new int[]{1, 1, 0};
        int[] b = new int[]{1, 1, 0};
        int[] c = new int[]{0, 0, 1};

        isConnected[0] = a;
        isConnected[1] = b;
        isConnected[2] = c;

        System.out.println(s.findCircleNum(isConnected));
    }
}

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        DSU dsu = new DSU(n);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1)
                    dsu.union(i, j);
            }
        }

        int count = 0;
        for (int i = 0; i < dsu.root.length; i++) {
            if (dsu.root[i] == i) {
                count++;
            }
        }
        return count;
    }

}

class DSU {
    public int[] root;
    public int[] rank;

    public DSU(int size) {
        root = new int[size];
        for (int i = 0; i < size; i++) {
            root[i] = i;
        }
        rank = new int[size];
    }

    int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]);
    }

    void union(int x, int y) {
        int xParent = find(x);
        int yParent = find(y);

        if (xParent != yParent) {
            if (rank[xParent] > rank[yParent]) {
                root[xParent] = yParent;
            } else if (rank[xParent] < rank[yParent]) {
                root[xParent] = yParent;
            } else {
                root[yParent] = xParent;
                rank[xParent]++;
            }
        }
    }
}