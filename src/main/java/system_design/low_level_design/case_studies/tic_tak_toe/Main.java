package system_design.low_level_design.case_studies.tic_tak_toe;

public class Main {
    public static void main(String args[]) {
        TicTacToeGame game = new TicTacToeGame();
        game.initializeGame();
        System.out.println("game winner is: " + game.startGame());
    }

}
