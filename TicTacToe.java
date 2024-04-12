import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public TicTacToe() {
        board = new Board();
        player1 = new Player('O');
        player2 = new Player('X');
        currentPlayer = player1;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        
        while (true) {
            System.out.println("Current Board:");
            board.displayBoard();
            System.out.println(currentPlayer.getSymbol() + "'s turn.");
            System.out.print("Enter row and column (0-2): ");
            row = scanner.nextInt();
            col = scanner.nextInt();
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
        char choice='y';
        while(choice=='y'){
            TicTacToe game = new TicTacToe();
            game.playGame();
            System.out.println("\nDo you want to play Again?(y/n): ");
            choice=scanner.next().charAt(0);
        }
        System.out.println("Thanks for playing.");
        scanner.close();
    }
}