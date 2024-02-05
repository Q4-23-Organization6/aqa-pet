import java.util.Scanner;
public class Players {
    public String name;
    public Variants variants;

    public Players(String name) {
        this.name = name;
    }

    public Variants getVariants() {
        return variants;
    }

    public void inputVariants() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(name + "input your choice - ROCK, PAPER or SCISSORS");
        String input = scanner.nextLine().toUpperCase();
        try {
            this.variants = Variants.valueOf(input);
        } catch (IllegalArgumentException e) {
            System.out.println("Wrong choice. Choose ROCK, PAPER or SCISSORS");
            inputVariants();
        }
    }
}
