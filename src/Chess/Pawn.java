package Chess;

public class Pawn extends ChessFigure implements Movable {

    /**
     * @param color Цвет фигуры: истина - белый, ложь - черный
     */

    int start_x;

    public Pawn(boolean color) {
        super(color, "P", color ? '\u2659' : '\u265F');
        this.start_x = color ? 1 : 6;
    }

    @Override
    public boolean canMove(Board board, int x, int y,
                           int to_x, int to_y) {
        int koeff = color ? 1 : -1;
        if (x + koeff == to_x && y == to_y) return true;
        else return start_x == x && x + 2 * koeff == to_x;
    }

    @Override
    public boolean can_attack(Board board, int x, int y, int to_x, int to_y) {
        int koeff = color ? 1 : -1;
        return x + koeff == to_x &&
                (y + koeff == to_y || y - koeff == to_y);
    }
}
