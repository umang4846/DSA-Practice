package dsa.stack;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int source = image[sr][sc];
        if (source != newColor) {
            dfs(image, sr, sc, newColor, source);
        }
        return image;
    }

    public void dfs(int[][] image, int sr, int sc, int newColor, int source) {

        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[sc].length) {
            return;
        }
        if (image[sr][sc] != source) {
            return;
        }
        //update the source pixel with new color
        image[sr][sc] = newColor;

        dfs(image, sr - 1, sc, newColor, source); // TOP
        dfs(image, sr + 1, sc, newColor, source); // DOWN
        dfs(image, sr, sc - 1, newColor, source); // LEFT
        dfs(image, sr, sc + 1, newColor, source); // RIGHT

    }

}
