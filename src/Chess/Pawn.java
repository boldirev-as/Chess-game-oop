package Chess;

public class Pawn extends ChessFigure implements Movable {
    int count;

    /**
     * @param color Цвет фигуры: истина - белый, ложь - черный
     * @param x     Координата Х
     * @param y     Координата У
     */
    public Pawn(boolean color, int x, int y) {
        this.count = 0;
        this.color = color;
        this.x = x;
        this.y = y;
        this.state = true;
        if (color)  this.symbol = '\u2659';
        else        this.symbol = '\u265f';
        this.id_f = ChessFigure.id++;
    }


    @Override
    public boolean isLive() {
        return this.state;
    }

    @Override
    public void moveFigure(int to_x, int to_y) {
        count++;
        super.moveFigure(to_x, to_y);
    }

    @Override
    public boolean canMove(int to_x, int to_y) {
        if(color) {
            if(count==0){}
            else{}
        }
        else {
            if(count==0){}
            else{}
        }


        return false;
    }
}
