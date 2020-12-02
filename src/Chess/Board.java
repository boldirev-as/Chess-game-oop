package Chess;

import java.util.Scanner;

public class Board {
    protected ChessFigure[][] field;
    private boolean color = true;
    public static final boolean WHITE = true;
    public static final boolean BLACK = false;

    public Board(){
        field = new ChessFigure[8][8];
        field[7] = new ChessFigure[] {
                new Rook(BLACK), new Knight(BLACK), new Bishop(BLACK), new Queen(WHITE),
                new King(BLACK), new Bishop(BLACK), new Knight(BLACK), new Rook(BLACK)};
        field[6] = new ChessFigure[] {
                new Pawn(BLACK), new Pawn(BLACK), new Pawn(BLACK),
                new Pawn(BLACK), new Pawn(BLACK), new Pawn(BLACK),
                new Pawn(BLACK), new Pawn(BLACK)};
        field[5] = new ChessFigure[] {
                new Empty(), new Empty(), new Empty(), new Empty(),
                new Empty(), new Empty(), new Empty(), new Empty()};
        field[4] = new ChessFigure[] {
                new Empty(), new Empty(), new Empty(), new Empty(),
                new Empty(), new Empty(), new Empty(), new Empty()};
        field[3] = new ChessFigure[] {
                new Empty(), new Empty(), new Empty(), new Empty(),
                new Empty(), new Empty(), new Empty(), new Empty()};
        field[2] = new ChessFigure[] {
                new Empty(), new Empty(), new Empty(), new Empty(),
                new Empty(), new Empty(), new Empty(), new Empty()};
        field[1] = new ChessFigure[] {
                new Pawn(WHITE), new Pawn(WHITE), new Pawn(WHITE),
                new Pawn(WHITE), new Pawn(WHITE), new Pawn(WHITE),
                new Pawn(WHITE), new Pawn(WHITE)};
        field[0] = new ChessFigure[] {
                new Rook(WHITE), new Knight(WHITE), new Bishop(WHITE), new Queen(WHITE),
                new King(WHITE), new Bishop(WHITE), new Knight(WHITE), new Rook(WHITE)};
    }

    public boolean CurrentPlayColor(){
        return color;
    }

    public String Cell(int x, int y){
        ChessFigure piece = field[x][y];
        if (piece instanceof Empty)
            return "  ";
        return (piece.GetColor() ? 'w' : 'b') + piece.ToChar();
    }

    public ChessFigure GetPiece(int x, int y){
        return field[x][y];
    }

    public boolean MoveChessPiece(int x, int y, int to_x, int to_y) {
        if (0 > x || x > 7 || 0 > y || y > 7 ||
                0 > to_x || to_x > 7 || 0 > to_y || to_y > 7)
            return false;
        if (x == to_x && y == to_y)
            return false;
        ChessFigure piece = this.GetPiece(x, y);
        if (piece instanceof Empty)
            return false;

        if (piece.GetColor() != this.CurrentPlayColor()) return false;

        if (this.Cell(to_x, to_y).equals("  ")){
            if (!piece.canMove(this, x, y, to_x, to_y))
                return false;
        }
        else if (this.GetPiece(to_x, to_y).GetColor() != piece.GetColor()) {
            if (!piece.can_attack(this, x, y, to_x, to_y))
                return false;
        } else
            return false;

        if (piece instanceof Pawn && (to_x == 0 || to_x == 7)) this.MoveAndPromotePawn(x, y, to_x, to_y);
        else {
            field[x][y] = new Empty();
            field[to_x][to_y] = piece;
            piece.first_move = false;
            color = !this.CurrentPlayColor();
        }
        return true;
    }

    public boolean Castling0(){
        int x = this.CurrentPlayColor() == BLACK ? 7 : 0;
        ChessFigure piece_king = this.GetPiece(x, 3);
        ChessFigure piece_rook = this.GetPiece(x, 0);
        if (piece_king.ToChar().equals("K") &&
                piece_rook.ToChar().equals("R") &&
                piece_king.first() && piece_rook.first()){
            if (!this.MoveChessPiece(x, 0, x, 2)) return false;
            field[x][1] = piece_king;
            field[x][3] = new Empty();
            return true;
        }
        return false;
    }

    public boolean Castling7() {
        int x = this.CurrentPlayColor() == BLACK ? 7 : 0;
        ChessFigure piece_king = this.GetPiece(x, 3);
        ChessFigure piece_rook = this.GetPiece(x, 7);
        if (piece_king.ToChar().equals("K") &&
                piece_rook.ToChar().equals("R") &&
                piece_king.first() && piece_rook.first()){
            if (!this.MoveChessPiece(x, 7, x, 4)) return false;
            field[x][5] = piece_king;
            field[x][3] = new Empty();
            return true;
        }
        return false;
    }

    public void MoveAndPromotePawn(int x, int y, int to_x,
                                      int to_y){
        System.out.println("В какую фигуру хотите превратить пешку (1. Rook, 2. Knight, 3. Bishop, 4. Queen)");
        Scanner sc = new Scanner(System.in);
        String sym = sc.next();
        os:
        for (;;){
            switch (sym) {
                case "1":
                case "2":
                case "3":
                case "4":
                    break os;
            }
            sym = sc.next();
        }
        boolean current_color = this.CurrentPlayColor();
        ChessFigure new_piece;
        switch (sym) {
            case "1": new_piece = new Rook(current_color); break;
            case "3": new_piece = new Bishop(current_color); break;
            case "2": new_piece = new Knight(current_color); break;
            case "4": new_piece = new Queen(current_color); break;
            default: throw new IllegalStateException("Unexpected value: " + sym);
        }
        field[x][y] = new Empty();
        field[to_x][to_y] = new_piece;
    }
}
