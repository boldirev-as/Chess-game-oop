package Chess;

import javax.swing.*;
import java.lang.reflect.Member;
import java.lang.reflect.Method;

public class Bishop extends ChessFigure {
    public Bishop(boolean color) {
        super(color, "B", color ? '\u2657' : '\u265D');
    }

    @Override
    public boolean canMove(Board board, int x, int y, int to_x, int to_y) {
        int step_1 = x > to_x ? -1 : 1;
        int step_2 = y > to_y ? -1 : 1;
        if (Math.abs(x - to_x) == Math.abs(y - to_y)) {
            if (Math.abs(x - to_x) == 1) return true;

            for (x += step_1, y += step_2; (Math.min(to_y, y) + 1) < Math.max(to_x, x);
                 x += step_1, y += step_2) {
                if (!(board.Cell(x, y).equals("  ")))
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
