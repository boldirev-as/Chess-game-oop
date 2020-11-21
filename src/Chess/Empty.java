package Chess;

public class Empty extends ChessFigure implements Movable {
    public Empty(int x, int y) {
        this.state = true;
        this.symbol = '\u2653';
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isLive() {
        return this.state;
    }

    @Override
    public boolean canMove(int to_x, int to_y) {
        return false;
    }
}
