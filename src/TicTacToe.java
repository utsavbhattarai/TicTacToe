//John W. Burris
//Tic-Tac-Toe. Two player.
//Feel free to use as a starting point for 5x5 and separating into MVC.
import java.util.Scanner;

public class TicTacToe {
    static final int X = 1;
    static final int O = -1;




    public static void main (String [] args) {
        Scanner input = new Scanner(System.in);
        TicTacToeController ticTacToeController = new TicTacToeController();
        ticTacToeController.gameOn();


    }
}