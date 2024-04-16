// Define a public class named Board
public class Board {
    // Private variables to represent the game board and its size
    private char[][] board;
    private int size;

    // Constructor to initialize the board with the given size
    public Board(int size) {
        this.size = size;
        // Create a 2D array to represent the game board
        board = new char[size][size];
        // Initialize the game board with empty cells
        initializeBoard();
    }

    // Method to initialize the game board with empty cells represented by '-'
    void initializeBoard() {
        // Nested loops to iterate through each cell of the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Assign '-' to each cell to represent an empty cell
                board[i][j] = '-';
            }
        }
    }

    // Method to display the current state of the game board
    void displayBoard() {
        // Display the top boundary of the board
        System.out.println("-------------");
        // Loop through each row of the board
        for (int i = 0; i < size; i++) {
            // Display the left boundary of each row
            System.out.print("| ");
            // Loop through each column of the board
            for (int j = 0; j < size; j++) {
                // Display the content of each cell followed by a vertical bar
                System.out.print(board[i][j] + " | ");
            }
            // Move to the next line and display the horizontal boundary of the board
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Method to check if a move is valid at the specified row and column for the given player
    boolean validMove(int row, int col, char player) {
        // Check if the specified cell is empty
        if (board[row][col] == '-') {
            // If empty, mark the cell with the player's symbol and return true
            board[row][col] = player;
            return true;
        }
        // If the cell is not empty, return false
        return false;
    }

    // Method to check if the specified player has won the game
    boolean checkWin(char player) {
        // Check for winning combinations in rows and columns
        for (int i = 0; i < size; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Check for winning combinations in diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        // If no winning combinations are found, return false
        return false;
    }

    // Method to check if the game board is full (i.e., no empty cells left)
    boolean isBoardFull() {
        // Loop through each cell of the board
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // If any cell is empty, return false
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        // If all cells are filled, return true
        return true;
    }

    // Method to check if the specified cell is empty
    boolean isEmptyCell(int row, int col) {
        // Check if the specified row and column are within the bounds of the board
        // and if the cell is empty
        if (row >= 0 && row < size && col >= 0 && col < size && board[row][col] == '-'){
             return true;
        } 
        // If any condition fails, return false
        return false;
    }

    // Method to get the size of the board
    int getSize(){
        return size;
    }
}
