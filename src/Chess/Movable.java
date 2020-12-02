package Chess;

public interface Movable {

    boolean canMove(Board board, int x, int y,
                    int to_x, int to_y);
}
