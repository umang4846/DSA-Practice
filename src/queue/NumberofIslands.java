package queue;

public class NumberofIslands {

    public int numIslands(char [][] grid){
        int count = 0;
        for(int i = 0; i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j){
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[i].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            dfs(grid,i+1,j); // left
            dfs(grid,i-1,j); //right
            dfs(grid,i,j+1); //up
            dfs(grid,i,j-1); //down
        }
    }

}
