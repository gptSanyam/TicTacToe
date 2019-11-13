import java.util.Scanner;

public class Game {

    final Board board = new Board();
    final Player p1;
    final Player p2;
    Scanner sc;
    Player currentPlayer;
    Player winner;
    Status status;

    Game(Player p1, Player p2, Scanner sc) {
        this.p1 = p1;
        this.p2 = p2;
        currentPlayer = p1;
        this.sc = sc;
    }

    public void start() {
        status = Status.IN_PROGRESS;
        while (status != Status.COMPLETED) {
            Board.Move position = makeMove();
            checkIfCurrentPlayerWonOrDraw(position);
            board.draw();
            switchPlayer();
        }
        printFinalStatus();
    }

    private void printFinalStatus() {
        if (winner != null) {
            System.out.println(winner.username + " won.");
        } else {
            System.out.println("Its a draw.");
        }
    }

    private void switchPlayer() {
        if (currentPlayer.equals(p1)) {
            currentPlayer = p2;
        } else {
            currentPlayer = p1;
        }
    }

    private void checkIfCurrentPlayerWonOrDraw(Board.Move position) { //check if the current player has won
        //set the status and winner flags
        board.applyMove(position, currentPlayer.symbol);
        boolean won = board.checkWin(position);
        if (won) {
            winner = currentPlayer;
        }

        if (won || board.isFull()) {
            status = Status.COMPLETED;
        }

    }

    private Board.Move makeMove() {//prompt user to make a move, check if the move is valid
        System.out.println(currentPlayer.username + ": Please select a valid position to move");
        try {
            int move = sc.nextInt();
            Board.Move mo = new Board.Move(move);
            board.isValidMove(mo);
            return mo;
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return makeMove();
        }
    }

    enum Status {
        IN_PROGRESS,
        COMPLETED
    }

}