import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class RockPaperScissors implements Loggable {

    private enum LogLevel {
        INFO, DEBUG, WARN, ERROR
    }
public void playGame() {
    logInfo("Starting the RockPaperScissors game...");

        Scanner scanner = new Scanner(System.in);

    while (true) {

        LogLevel logLevel = promptLogLevel(scanner);


        switch (logLevel) {
            case INFO:
                logInfo("Starting a new round...");
                break;
            case DEBUG:
                logDebug("Starting a new round...");
                break;
            case WARN:
                logWarn("Starting a new round...");
                break;
            case ERROR:
                logError("Starting a new round...");
                break;
        }
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
        logInfo("Round finished.");

        System.out.println("Do you want to play again? (yes/no)");
        String playAgain = scanner.next();
        if (!playAgain.equalsIgnoreCase("yes")) {
        break;
        }
        }
    logInfo("RockPaperScissors game finished.");
        }
    private LogLevel promptLogLevel(Scanner scanner) {
        System.out.println("Choose log level (INFO, DEBUG, WARN, ERROR):");
        String input = scanner.next().toUpperCase();
        return LogLevel.valueOf(input);
    }
public static void main(String[] args) {
        RockPaperScissors game = new RockPaperScissors();
        game.playGame();
        }
        }