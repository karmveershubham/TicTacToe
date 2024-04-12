import java.util.Scanner;
import java.util.Random;

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
        Scanner scanner = new Scanner(System.in);
        System.out.println(player + "'s turn.");
        System.out.print("Enter row and column (0-2): ");
        int row = scanner.nextInt();
        int col = scanner.nextInt();
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
