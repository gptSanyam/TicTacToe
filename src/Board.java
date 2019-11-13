public class Board {

    Character[][] brd = new Character[3][3];

    public Board() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                brd[i][j] = ' ';
            }
        }
    }

    public void isValidMove(Move move) {
        isFree(move.row, move.col);
    }

    public void isFree(int row, int col) {
        if (!brd[row][col].equals(' ')) {
            throw new RuntimeException("Not a valid move");
        }
    }

    public void draw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(brd[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void applyMove(Move position, Character symbol) {
        brd[position.row][position.col] = symbol;
    }

    public boolean checkWin(Move position) {
        int ROW = position.row;
        int COL = position.col;
        Character SYM = brd[ROW][COL];
        //row keeping i same iterate over columns
        boolean rowSame = true;
        for (int col = 0; col < 3; col++) {
            if (!SYM.equals(brd[ROW][col])) {
                rowSame = false;
            }
        }
        //col
        boolean colSame = true;
        for (int row = 0; row < 3; row++) {
            if (!SYM.equals(brd[row][COL])) {
                colSame = false;
            }
        }

        //45 diagnol i-1, j
        boolean diag45Sam = brd[0][0].equals(brd[1][1]) && brd[2][2].equals(brd[1][1]) && brd[1][1].equals(SYM);

        //135 diagonal
        boolean diag135Sam = brd[0][2].equals(brd[1][1]) && brd[1][1].equals(brd[2][0]) && brd[1][1].equals(SYM);

        return rowSame || colSame || diag45Sam || diag135Sam;
    }

    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (brd[i][j].equals(' ')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static class Move {
        public int row;
        public int col;

        public Move(int move) {
            switch (move) {
                case 1:
                    row = 0;
                    col = 0;
                    break;
                case 2:
                    row = 0;
                    col = 1;
                    break;
                case 3:
                    row = 0;
                    col = 2;
                    break;
                case 4:
                    row = 1;
                    col = 0;
                    break;
                case 5:
                    row = 1;
                    col = 1;
                    break;
                case 6:
                    row = 1;
                    col = 2;
                    break;
                case 7:
                    row = 2;
                    col = 0;
                    break;
                case 8:
                    row = 2;
                    col = 1;
                    break;
                case 9:
                    row = 2;
                    col = 2;
                    break;
                default:
                    throw new RuntimeException("Not a valid move");

            }

        }
    }


}