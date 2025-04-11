package dsa.recursion;

public class N_QueensII {

    public int totalNQueens(int n) {
        return solve(new boolean[n][n], 0);
    }

    public int solve(boolean[][] board, int row){
        if(row == board.length){
            return 1;
        }
        int count = 0;
        for(int i=0; i<board.length; i++){
            if(!board[row][i] && isQueenSafe(board, row, i)){
                //set true
                board[row][i] = true;
                //add no of possible ways
                count = count + solve(board, row+1);
                //set false to explore another way
                board[row][i] = false;
            }
        }
        return count;
    }

    public boolean isQueenSafe(boolean[][] board, int row, int col){
        //Check Vertically |
        for(int i= row-1; i>=0; i--){
            if(board[i][col]){
                return false;
            }
        }
        //Check left Diagonal \
        for(int i = row - 1, j = col - 1; i>=0 && j>=0; i--,j--){
            if(board[i][j]){
                return false;
            }
        }
        //Check Right Diagonal /
        for(int i = row-1, j=col+1; i>=0 && j<board.length; i--,j++){
            if(board[i][j]){
                return false;
            }
        }
        return true;
    }

}

