import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    boolean againstComputer=false;;

    public TicTacToe(int vsComputer,char symbol) {
        board = new Board();
        if(symbol=='O' ||symbol=='o'){
            player1 = new Player('O');
            player2 = new Player('X'); 
        }else{
            player1 = new Player('X');
            player2 = new Player('O'); 
        }
        if (vsComputer==2) {
           againstComputer=true;
        }
        currentPlayer = player1;
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        int row, col;
        while (true) {
            System.out.println("Current Board:");
            board.displayBoard();
            if (againstComputer && currentPlayer == player2) {
                System.out.println(currentPlayer.getSymbol() + "'s turn.\n");
                Random rand = new Random();
                do {
                    row = rand.nextInt(3);
                    col = rand.nextInt(3);
                } while (!board.isEmptyCell(row, col));
            }else {
                System.out.println(currentPlayer.getSymbol() + "'s turn.");
                System.out.print("Enter row and column (0-2): ");
                row = scanner.nextInt();
                col = scanner.nextInt();
            }
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
        while(choice=='y' || choice=='Y'){
            System.out.println("\n------------TIC TAC TOE------------\n");
            System.out.println("Choose Mode:  1.Play with Friends  2.play Against Computer.");
            int vsComputer=scanner.nextInt();
            System.out.print("Choose Symbol: (X/O) \t ");
            char symbol=scanner.next().charAt(0);
            TicTacToe game = new TicTacToe(vsComputer,symbol);
            game.playGame();
            System.out.println("\nDo you want to play Again?(y/n): ");
            choice=scanner.next().charAt(0);
        }
        System.out.println("Thanks for playing.");
        scanner.close();
    }
}