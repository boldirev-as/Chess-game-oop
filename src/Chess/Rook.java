package Chess;

public class Rook extends ChessFigure {
    public Rook(boolean color) {
        super.ChessFigure(color, "R");
    }

    @Override
    public boolean canMove(Board board, int x, int y, int to_x, int to_y) {
        if (x == to_x){
            int direction = y < to_y ? 1 : -1;
            for (; Math.max(y, to_y) > (Math.min(y, to_y) + 1); y += direction) {
                if (!board.Cell(x, y).equals("  "))
                    return false;
            }
            return true;
        } else if (y == to_y){
            int direction = x < to_x ? 1 : -1;
            for (; Math.max(x, to_x) > (Math.min(x, to_x) + 1); x += direction) {
                if (!board.Cell(x, y).equals("  "))
                    return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean can_attack(Board board, int x, int y, int to_x, int to_y) {
        return this.canMove(board, x, y, to_x, to_y);
    }
}
