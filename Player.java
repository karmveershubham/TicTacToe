import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;
public class Player{
    protected char player;

    public Player(char player) {
        this.player = player;
    }

    public char getSymbol() {
        return player;
    }

    public int[] makeMove(Board board) {
        return null;
    }
}

class HumanPlayer extends Player {
    public HumanPlayer(char player) {
        super(player);
    }

    @Override
    public int[] makeMove(Board board) {
        int row = -1; // Initializing to -1 to ensure we detect if the input was invalid
        int col = -1;
        Scanner scanner = new Scanner(System.in);
        System.out.println(player + "'s turn.");
        System.out.print("Enter row and column (0-2): ");
        while (row < 0 || row > 2 || col < 0 || col > 2) { // Keep asking until valid input is received
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid input! Row and column must be between 0 and 2.");
                    System.out.print("Enter row and column (0-2): ");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a valid numeric value for row and column.");
                scanner.next(); // Consume invalid input to avoid infinite loop
                System.out.print("Enter row and column (0-2): ");
            }
        }
        return new int[]{row, col};
    }
}



class ComputerPlayer extends Player {
    public ComputerPlayer(char player) {
        super(player);
    }

    @Override
    public int[] makeMove(Board board) {
        System.out.println(player + "'s turn.");
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(board.getSize());
            col = rand.nextInt(board.getSize());
        } while (!board.isEmptyCell(row, col));
        return new int[]{row, col};
    }
}
