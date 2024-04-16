import java.util.InputMismatchException;
import java.util.Scanner;

// Class representing the Tic Tac Toe game
public class TicTacToe {
    private Board board;  
    private Player player1;
    private Player player2; 
    private Player currentPlayer;
    boolean vsComputer; 

    // Constructor
    public TicTacToe(boolean vsComputer, char player) {
        char symbol = Character.toUpperCase(player);
        this.vsComputer = vsComputer;
        board = new Board(3); 
        player1 = new HumanPlayer(symbol);
        // Create player 2 either as a human or Computer 
        player2 = vsComputer ? new ComputerPlayer((symbol == 'X') ? 'O' : 'X') : new HumanPlayer((symbol == 'X') ? 'O' : 'X');
        currentPlayer = player1; // Set player 1 as the current player
    }

    // Method to start and manage the game
    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Current Board:");
            board.displayBoard();
            int[] move = currentPlayer.makeMove(board); // Get the current player's move
            row = move[0]; 
            col = move[1]; 
            // Check ivalid move
            if (board.validMove(row, col, currentPlayer.getSymbol())) {
                // Check if the current player has won or tie.
                if (board.checkWin(currentPlayer.getSymbol())) {
                    System.out.println("Current Board:");
                    board.displayBoard();
                    System.out.println(currentPlayer.getSymbol() + " wins!");
                    break; 
                } else if (board.isBoardFull()) {
                    System.out.println("It's a tie!");
                    break; 
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1; // Switch to the other player
                }
            } else {
                System.out.println("Invalid move! Try again.");
            }
        } 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char choice = 'y'; 

        while (Character.toUpperCase(choice) == 'Y') {
            System.out.println("\n------------TIC TAC TOE------------\n");
            try {
                System.out.println("Choose Mode:  1.Play Against Friends  2.Play Against Computer.");
                int mode = scanner.nextInt(); // Get the user's choice for game mode
                if (mode != 1 && mode != 2) {
                    System.out.println("Invalid mode selected. Please choose 1 or 2.");
                    continue; 
                }
                System.out.print("Choose Symbol: (X/O) \t "); //select symbol
                char symbol = scanner.next().charAt(0); 
                if (Character.toUpperCase(symbol) != 'X' && Character.toUpperCase(symbol) != 'O') {
                    System.out.println("Invalid symbol selected. Please choose 'X' or 'O'.");
                    continue; 
                }
                // Create a new TicTacToe game instance 
                TicTacToe game = (mode == 2) ? new TicTacToe(true, symbol) : new TicTacToe(false, symbol);
                game.playGame(); 
                System.out.println("\nDo you want to play Again?(y/n): ");
                choice = scanner.next().charAt(0); // Choice to play again
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid numeric choice.");
                scanner.next(); // Consume the invalid input
            }
        }
        System.out.println("Thanks for playing.");
        scanner.close(); 
    }
}
