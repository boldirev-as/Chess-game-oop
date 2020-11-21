package Chess;

public interface Movable {

    boolean isLive();

    boolean canMove(int to_x, int to_y);

}
