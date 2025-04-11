package dsa.kunal_kushwaha_dsa.backtracking;

public class SudokuSolver {
    public static void main(String[] args) {
        int[][] board = new int[][]{
                {3, 0, 6, 5, 0, 8, 4, 0, 0},
                {5, 2, 0, 0, 0, 0, 0, 0, 0},
                {0, 8, 7, 0, 0, 0, 0, 3, 1},
                {0, 0, 3, 0, 1, 0, 0, 8, 0},
                {9, 0, 0, 8, 6, 3, 0, 0, 5},
                {0, 5, 0, 0, 9, 0, 6, 0, 0},
                {1, 3, 0, 0, 0, 0, 2, 5, 0},
                {0, 0, 0, 0, 0, 0, 0, 7, 4},
                {0, 0, 5, 2, 0, 6, 3, 0, 0}
        };

        solve(board);
        display(board);
    }

    private static void display(int[][] board) {
        for (int[] row : board){
            for (int cell : row){
                System.out.print(cell +" ");
            }
            System.out.println();
        }
    }

    private static boolean solve(int[][] board){

        for(int i = 0;i<9;i++){
            for(int j = 0;j<9;j++){
                if(board[i][j] == 0){
                    for(int k =1;k<=9;k++){
                        if(isValid(board,i,j,k)){
                            board[i][j] = k;
                            if(solve(board) == true)
                                return true;
                            else
                                board[i][j] = 0;
                        }
                    }
                    return false; //not able to place any num from 1-9 at i,j
                }
            }
        }
        return true;
    }

    private static boolean isValid(int [][] board,int row,int col,int val){//o(n)
        //check entire col,row
        for(int i = 0;i<9;i++){
            if(board[i][col] == val) return false;
            if(board[row][i] == val) return false;
        }

        //getting the top left corner of 3 cross 3 matrix
        //row/3 & col/3 gives u exact subarray box , we multiply these by 3
        //so that we can get the top left corner of that box(i.e box starting)
        int rowStart = (row/3) * 3;
        int colStart = (col/3) * 3;

        //checking the 3 cross 3 sub-matrix
        for(int i = 0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(board[rowStart + i][colStart + j] == val) return false;
            }
        }
        return true;
    }
}
