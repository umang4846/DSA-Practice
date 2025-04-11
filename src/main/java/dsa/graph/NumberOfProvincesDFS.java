package dsa.graph;

public class NumberOfProvincesDFS {
    public static void main(String[] args) {
        int[][] isConnected = new int[4][4];

        int[] a = new int[]{1, 1, 0};
        int[] b = new int[]{1, 1, 0};
        int[] c = new int[]{0, 0, 1};

        isConnected[0] = a;
        isConnected[1] = b;
        isConnected[2] = c;

        System.out.println(findCircleNum(isConnected));
    }

    public static int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i, isConnected, visited);
                count++;
            }
        }
        return count;

    }

    private static void DFS(int U, int[][] isConnected, boolean[] visited) {
        visited[U] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i] && isConnected[U][i] == 1) {
                DFS(i, isConnected, visited);
            }
        }
    }
}


