package Chess;

public abstract class ChessFigure {
    protected boolean color;
    private final String symbol;
    protected boolean first_move = false;
    protected char vision;

    public ChessFigure(boolean color, String symbol, char vision) {
        this.color = color;
        this.symbol = symbol;
        this.vision = vision;
    }

    public char getVision() {return vision;}

    public boolean GetColor(){
        return color;
    }

    public String ToChar() {
        return symbol;
    }

    public boolean first() {return first_move;}

    public abstract boolean canMove(Board board, int x, int y,
                                    int to_x, int to_y);

    public abstract boolean can_attack(Board board, int x, int y,
                                       int to_x, int to_y);
}
