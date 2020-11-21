package Chess;

public abstract class ChessFigure {
    boolean color, state;
    int x, y, id_f;
    public static int id;
    char symbol;

    public void moveFigure(int to_x, int to_y) {
        x = to_x;
        y = to_y;
    }

    public void ChessFigure(boolean color, byte x, byte y, char sym) {
        this.color = color;
        this.symbol = sym;
        this.state = true;
        this.x = x;
        this.y = y;
    }

    public String toString() {
        if (state && (symbol > '\u2652' && symbol < '\u2660'))
            return String.valueOf(symbol);
        else
            return " ";
    }

}
