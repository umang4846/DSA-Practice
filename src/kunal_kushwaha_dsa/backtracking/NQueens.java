package kunal_kushwaha_dsa.backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 5;
        boolean[][] board = new boolean[n][n];
        System.out.println(queens(board,0));
    }

    public static int queens(boolean[][] board, int row){
        if(row == board.length){
            display(board);
            System.out.println();
            return 1;
        }
        int count = 0;
        for (int col =0; col< board.length;col++){
            if (isQueenSafe(board,row,col)){
                board[row][col] = true;
                count = count + queens(board,row+1);
                board[row][col] = false;
            }
        }
        return count;
    }

    private static boolean isQueenSafe(boolean[][] board, int row, int col) {
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

    private static void display(boolean[][] board) {
        for (boolean[] row : board){
            for (boolean cell : row){
                if (cell){
                    System.out.print("Q ");
                }else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
