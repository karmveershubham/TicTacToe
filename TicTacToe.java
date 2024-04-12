import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    boolean vsComputer;

    public TicTacToe(boolean vsComputer, char player) {
        char symbol=Character.toUpperCase(player);
        this.vsComputer = vsComputer;
        board = new Board(3); 
        player1 = new HumanPlayer(symbol);
        player2 = vsComputer ? new ComputerPlayer((symbol == 'X') ? 'O' : 'X') : new HumanPlayer((symbol == 'X') ? 'O' : 'X');
        currentPlayer = player1;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Current Board:");
            board.displayBoard();
            int[] move = currentPlayer.makeMove(board);
            row = move[0];
            col = move[1];
            if (board.makeMove(row, col, currentPlayer.getSymbol())) {
                if (board.checkWin(currentPlayer.getSymbol())) {
                    System.out.println("Current Board:");
                    board.displayBoard();
                    System.out.println(currentPlayer.getSymbol() + " wins!");
                    break;
                } else if (board.isBoardFull()) {
                    System.out.println("It's a tie!");
                    break;
                } else {
                    currentPlayer = (currentPlayer == player1) ? player2 : player1;
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
            System.out.println("Choose Mode:  1.Play with Friends  2.Play Against Computer.");
            int mode = scanner.nextInt();
            if (mode != 1 && mode != 2) {
                System.out.println("Invalid mode selected. Please choose 1 or 2.");
                continue;
            }
            System.out.print("Choose Symbol: (X/O) \t ");
            char symbol = scanner.next().charAt(0);
            if (Character.toUpperCase(symbol) != 'X' && Character.toUpperCase(symbol) != 'O') {
                System.out.println("Invalid symbol selected. Please choose 'X' or 'O'.");
                continue;
            }
            TicTacToe game = (mode == 2) ? new TicTacToe(true, symbol) : new TicTacToe(false, symbol);
            game.playGame();
            System.out.println("\nDo you want to play Again?(y/n): ");
            choice = scanner.next().charAt(0);
        }
        System.out.println("Thanks for playing.");
        scanner.close();
    }
}
