import java.util.Scanner;
public class TicTacToeController {

    public static TicTacToeModel ticTacToeModel = new TicTacToeModel();
    public static TicTacToeView ticTacToeView = new TicTacToeView();
    static final int X = 1;
    static final int O = -1;
    public static Scanner input = new Scanner(System.in);

    //hasWon returns true if there was a win or a cat game.
    public static boolean hasWon( int [][] matrix ){
        //Variable holds the "result" of hasWon. True if a winner was found.
        boolean retVal = false;

        //Check for horizontal win
        for( int row = 0; row < matrix.length; row++ ){
            int sum = 0;
            for( int col = 0; col < matrix[0].length; col++ ){
                sum += matrix[row][col];
            }
            //Check to see if the sum of that row was 5 or -5, a win...
            if( sum == 5 ){
                System.out.println("X wins.");
                retVal = true;
            } else if ( sum == -5 ) {
                System.out.println("O wins.");
                retVal = true;
            }
        }

        //Check for vertical win
        for( int col = 0; col < matrix[0].length; col++ ){
            int sum = 0;
            for( int row = 0; row < matrix.length; row++ ){
                sum += matrix[row][col];
            }
            //Check to see if the sum of that column was 5 or -5, a win...
            if( sum == 5 ){
                System.out.println("X wins.");
                retVal = true;
            } else if ( sum == -5 ) {
                System.out.println("O wins.");
                retVal = true;
            }
        }

        //Check for diagonal win
        if( (matrix[0][0] + matrix[1][1] + matrix[2][2] + matrix[3][3] + matrix[4][4]) == 5 ){
            System.out.println("X wins.");
            retVal = true;
        } else if ( (matrix[0][0] + matrix[1][1] + matrix[2][2] +  matrix[3][3] + matrix[4][4]) == -5 ) {
            System.out.println("O wins.");
            retVal = true;
        }
        if( (matrix[0][4] + matrix[1][3] + matrix[2][2] + matrix[3][1] + matrix[4][0]) == 5 ){
            System.out.println("X wins.");
            retVal = true;
        } else if ( (matrix[0][4] + matrix[1][3] + matrix[2][2] + matrix[3][1] + matrix[4][0]) == -5 ) {
            System.out.println("O wins.");
            retVal = true;
        }

        //Check for cat game
        boolean foundSpace = false;
        for( int row = 0; row < matrix.length; row++ ){
            for( int col = 0; col < matrix[0].length; col++ ){
                if( matrix[row][col] == 0 )
                    foundSpace = true;
            }
        }
        if( foundSpace == false ){
            System.out.println("Ends in tie.");
            retVal = true;
        }

        return retVal;
    }

    public static void gameOn() {
        while( hasWon(ticTacToeModel.board) == false){

            //Get the X player input and make the change if not taken.
            System.out.print("X, enter row: ");
            int row = input.nextInt();
            System.out.print("X, enter column: ");
            int col = input.nextInt();
            if( ticTacToeModel.board[row][col] == 0 )
                ticTacToeModel.board[row][col] = X;

            ticTacToeView.printBoard(ticTacToeModel.board);

            //Check to see if X's move won the game. If so, break out of game loop
            if( hasWon(ticTacToeModel.board) == true )
                break;

            //Get the O player input and make the change if not taken.
            System.out.print("O, enter row: ");
            row = input.nextInt();
            System.out.print("O, enter column: ");
            col = input.nextInt();
            if( ticTacToeModel.board[row][col] == 0 )
                ticTacToeModel.board[row][col] = O;

            ticTacToeView.printBoard(ticTacToeModel.board);

        }

        System.out.println("Game over.");
    }

}
