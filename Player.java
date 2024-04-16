import java.util.Scanner;
import java.util.Random;
import java.util.InputMismatchException;

// Define a Player class
public class Player {
    protected char player; // Player symbol (X or O)

    // Constructor to initialize player symbol
    public Player(char player) {
        this.player = player;
    }

    // Method to get player symbol
    public char getSymbol() {
        return player;
    }

    // Method to make a move on the board (abstract method)
    public int[] makeMove(Board board) {
        return null; // Default implementation returns null
    }
}

// Define a subclass HumanPlayer which extends Player
class HumanPlayer extends Player {
    // Constructor to initialize human player
    public HumanPlayer(char player) {
        super(player); // Call superclass constructor
    }

    // Method to make a move on the board (override superclass method)
    @Override
    public int[] makeMove(Board board) {
        int row = -1; // Initialize row to -1 to ensure detection of invalid input
        int col = -1; // Initialize col to -1 to ensure detection of invalid input
        Scanner scanner = new Scanner(System.in);
        System.out.println(player + "'s turn.");
        System.out.print("Enter row and column (0-2): ");
        while (row < 0 || row > 2 || col < 0 || col > 2) { // Loop until valid input is received
            try {
                row = scanner.nextInt();
                col = scanner.nextInt();
                if (row < 0 || row > 2 || col < 0 || col > 2) {
                    System.out.println("Invalid input! Row and column must be between 0 and 2.");
                    System.out.print("Enter row and column (0-2): ");
                }
            } catch (InputMismatchException e) { // Handle non-integer input
                System.out.println("Invalid input! Please enter a valid numeric value for row and column.");
                scanner.next(); // Consume invalid input to avoid infinite loop
                System.out.print("Enter row and column (0-2): ");
            }
        }
        return new int[]{row, col}; // Return the chosen row and column
    }
}

// Define a subclass ComputerPlayer which extends Player
class ComputerPlayer extends Player {
    // Constructor to initialize computer player
    public ComputerPlayer(char player) {
        super(player); // Call superclass constructor
    }

    // Method to make a move on the board (override superclass method)
    @Override
    public int[] makeMove(Board board) {
        System.out.println(player + "'s turn.");
        Random rand = new Random();
        int row, col;
        // Randomly choose row and column until finding an empty cell
        do {
            row = rand.nextInt(board.getSize()); // Generate random row index
            col = rand.nextInt(board.getSize()); // Generate random column index
        } while (!board.isEmptyCell(row, col)); // Continue until finding an empty cell
        return new int[]{row, col}; // Return the chosen row and column
    }
}
