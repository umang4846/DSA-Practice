package dsa.kunal_kushwaha_dsa.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Maze {

    /* 3  2  1
     * 3| | | |
     * 2| | | |
     * 1| | | |
     *
     * */

    public static void main(String[] args) {
        //System.out.println(count(3,3));
        //  path("",3,3);
        // System.out.println(pathList("", 3, 3));
        // System.out.println(pathListDiagonal("",3,3));

        boolean[][] maze = {
                {true, true, true},
                {true, false, true},
                {true, true, true}
        };
        pathRestriction("",maze,0,0);
    }


    static int count(int row, int col) {
        if (row == 1 || col == 1) {
            return 1;
        }
        int right = count(row, col - 1);
        int down = count(row - 1, col);
        return right + down;
    }

    static void path(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            System.out.println(processed);
            return;
        }
        if (row > 1) {
            path(processed + "D", row - 1, col);
        }
        if (col > 1) {
            path(processed + "R", row, col - 1);
        }
    }

    static List<String> pathList(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> ans = new ArrayList<>();
        if (row > 1) {
            ans.addAll(pathList(processed + "D", row - 1, col));
        }
        if (col > 1) {
            ans.addAll(pathList(processed + "R", row, col - 1));
        }
        return ans;
    }

    static List<String> pathListDiagonal(String processed, int row, int col) {
        if (row == 1 && col == 1) {
            List<String> list = new ArrayList<>();
            list.add(processed);
            return list;
        }
        List<String> ans = new ArrayList<>();
        /*
         * D -> Diagonal
         * V -> Vertical
         * H -> Horizontal
         * */
        if (row > 1 && col > 1) {
            ans.addAll(pathListDiagonal(processed + "D", row - 1, col - 1));
        }
        if (row > 1) {
            ans.addAll(pathListDiagonal(processed + "V", row - 1, col));
        }
        if (col > 1) {
            ans.addAll(pathListDiagonal(processed + "H", row, col - 1));
        }
        return ans;
    }

    static void pathRestriction(String processed, boolean[][] maze, int row, int col) {
        if (row == maze.length - 1 && col == maze[0].length - 1) {
            System.out.println(processed);
            return;
        }
        if (!maze[row][col]) {
            return;
        }
        if (row < maze.length - 1) {
            pathRestriction(processed + "D", maze, row + 1, col);
        }
        if (col < maze[0].length - 1) {
            pathRestriction(processed + "R", maze, row, col + 1);
        }
    }
}
