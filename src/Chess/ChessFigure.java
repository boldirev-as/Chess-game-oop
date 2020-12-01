package Chess;

public abstract class ChessFigure {
    protected boolean color;
    private String symbol;
    protected boolean first_move = false;

    public void ChessFigure(boolean color, String symbol) {
        this.color = color;
        this.symbol = symbol;
    }

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
