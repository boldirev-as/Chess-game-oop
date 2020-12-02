package Chess;

public class Empty extends ChessFigure implements Movable {
    public Empty() {
        super(false, " ", '\\');
    }

    @Override
    public boolean canMove(Board board, int x, int y, int to_x, int to_y) {
        return false;
    }

    @Override
    public boolean can_attack(Board board, int x, int y, int to_x, int to_y) {
        return false;
    }
}
