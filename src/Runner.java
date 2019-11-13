import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter name of player 1: ");
        String p1 = sc.nextLine();
        System.out.println("Please enter name of player 2: ");
        String p2 = sc.nextLine();

        Game game = new Game(new Player(p1, 'X'), new Player(p2, 'O'), sc);
        game.start();
    }
}