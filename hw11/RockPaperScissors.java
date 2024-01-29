import java.util.Scanner;
public class RockPaperScissors {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            Players player1 = new Players("Player 1");
            Players player2 = new Players("Player 2");

           player1.inputVariants();
           player2.inputVariants();

            Variants variants1 = player1.getVariants();
            Variants variants2 = player2.getVariants();

            System.out.println("Player 1 chose: " + variants1);
            System.out.println("Player 2 chose: " + variants2);

            if (variants1 == variants2) {
                System.out.println("Draw");
            } else if ((variants1 == Variants.ROCK && variants2 == Variants.SCISSORS) ||
                    (variants1 == Variants.PAPER && variants2 == Variants.ROCK) ||
                    (variants1 == Variants.SCISSORS && variants2 == Variants.PAPER)) {
                System.out.println("Player 1 won");
            } else {
                System.out.println("Player 2 won");
            }
            System.out.println("Want to play again? (yes/no)");
            String playAgain = scanner.next();
            if (!playAgain.equalsIgnoreCase("yes")) {
                break;
            }
        }
        System.out.println("Thank you for the Game!");
    }

}