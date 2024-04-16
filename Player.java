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
