import Chess.ChessFigure;
import Chess.Empty;
import Chess.Pawn;

public class Main {

    public static ChessFigure[][] Field;

    public static void main(String[] args) {
        Field = new ChessFigure[8][8];
        for (int i = 0; i < Field.length; i++)
            for (int j = 0; j < Field[i].length; j++)
                Field[i][j] = new Empty(i, j);
        for (int i = 0; i < Field.length; i++) {
            Field[1][i] = new Pawn(true, 1, i);
            Field[6][i] = new Pawn(false, 6, i);
        }

        for (int i = 0; i < Field.length; i++) {
            for (int j = 0; j < Field[i].length; j++)
                System.out.print(Field[i][j] + (j == 7 ? "\n" : ""));
        }

    }
}
