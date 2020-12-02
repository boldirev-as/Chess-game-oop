package Chess;

public class Knight extends ChessFigure {
    public Knight(boolean current_color) {
        super(current_color, "N", current_color ? '\u2658' : '\u265E');
    }

    @Override
    public boolean canMove(Board board, int x, int y, int to_x, int to_y) {
        return Math.abs(x - to_x) * Math.abs(y - to_y) == 2;
    }

    @Override
    public boolean can_attack(Board board, int x, int y, int to_x, int to_y) {
        return this.canMove(board, x, y, to_x, to_y);
    }
}
