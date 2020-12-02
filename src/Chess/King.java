package Chess;

public class King extends ChessFigure {
    public King(boolean color) {
        super(color, "K", color ? '\u2654' : '\u265A');
    }

    @Override
    public boolean canMove(Board board, int x, int y, int to_x, int to_y) {
        int direction = Math.abs(x - to_x) * Math.abs(y - to_y);
        return direction == 1 || direction == 0;
    }

    @Override
    public boolean can_attack(Board board, int x, int y, int to_x, int to_y) {
        return this.canMove(board, x, y, to_x, to_y);
    }
}
