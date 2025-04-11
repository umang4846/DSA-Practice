package dsa.kunal_kushwaha_dsa.backtracking;

import java.util.Arrays;

public class AllPaths {
    public static void main(String[] args) {
        boolean[][] maze = {
                {true, true, true},
                {true, true, true},
                {true, true, true}
        };

        int[][] path = new int[maze.length][maze[0].length];
       // allPaths("",maze,0,0);
        allPathPrint("",maze,0,0,path,1);
    }

    static void allPaths(String processed, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }
        if (!maze[row][col]) {
            return;
        }
        //i am considering this cell in my path
        maze[row][col] = false;
        //Down
        if (row < maze.length - 1) {
            allPaths(processed + "D", maze, row + 1, col);
        }
        //Right
        if (col < maze[0].length - 1) {
            allPaths(processed + "R", maze, row, col + 1);
        }
        //Up
        if (row > 0) {
            allPaths(processed + "U", maze, row - 1, col);
        }
        //Left
        if (col > 0) {
            allPaths(processed + "L", maze, row, col - 1);
        }
        //this line is where the function will be over
        //so before function gets removed, also remove the changes that were made by that function
        maze[row][col] = true;
    }

    static void allPathPrint(String processed, boolean[][] maze, int row, int col, int[][]path, int step) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            path[row][col] = step;
            for (int[] arr : path){
                System.out.println(Arrays.toString(arr));
            }
            System.out.println(processed);
            System.out.println();
            return;
        }
        if (!maze[row][col]) {
            return;
        }
        //i am considering this cell in my path
        maze[row][col] = false;

        path[row][col] = step;
        //Down
        if (row < maze.length - 1) {
            allPathPrint(processed + "D", maze, row + 1, col, path, step+1);
        }
        //Right
        if (col < maze[0].length - 1) {
            allPathPrint(processed + "R", maze, row, col + 1, path, step+1);
        }
        //Up
        if (row > 0) {
            allPathPrint(processed + "U", maze, row - 1, col,path,step+1);
        }
        //Left
        if (col > 0) {
            allPathPrint(processed + "L", maze, row, col - 1,path,step+1);
        }
        //this line is where the function will be over
        //so before function gets removed, also remove the changes that were made by that function
        maze[row][col] = true;
        path[row][col] = 0;
    }
}
