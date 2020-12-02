import Chess.Board;

import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Board board = new Board();
        for (;;){
            print_board(board);
            System.out.println("Команды:");
            System.out.println("    exit                               -- выход");
            System.out.println("    move <row> <col> <row1> <row1>     -- ход из клетки (row, col)");
            System.out.println("                                          в клетку (row1, col1)");
            System.out.println("    rock <col>                         -- рокировка с ладьей стоящей");
            System.out.println("                                          в колонне col(0 или 7)");

            if (board.CurrentPlayColor() == Board.WHITE)
                System.out.println("Ход белых:");
            else
                System.out.println("Ход чёрных:");
            String command = sc.nextLine();
            if (command.equals("exit")) break;
            if (command.startsWith("rock")){
                if (command.charAt(5) == '0')
                    if (!board.Castling0())
                        System.out.println("Координаты некорректы! Попробуйте другой ход!");
                else
                    if (!board.Castling7())
                        System.out.println("Координаты некорректы! Попробуйте другой ход!");
            } else {
                if (board.MoveChessPiece(
                        Integer.parseInt(command.substring(5, 6)),
                        Integer.parseInt(command.substring(7, 8)),
                        Integer.parseInt(command.substring(9, 10)),
                        Integer.parseInt(command.substring(11, 12))))
                    System.out.println("Ход успешен");
                else
                    System.out.println("Координаты некорректы! Попробуйте другой ход!");
            }
        }
    }

    public static void print_board(Board board) {
        System.out.println("      +----+----+----+----+----+----+----+----+");
        for (int i = 7; i > -1; i--) {
            System.out.print("  " + i + "   ");
            for (int j = 0; j < 8; j++)
                System.out.print("| " + board.Cell(i, j) + " ");
            System.out.println("|");
            System.out.println("      +----+----+----+----+----+----+----+----+");
        }
        System.out.print("        ");
        for (int i = 0; i < 8; i++)
            System.out.print(i + "    ");
        System.out.println();
    }
}
