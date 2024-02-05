import java.util.ArrayList;
import java.util.Random;

public class TaskOne {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 100; i++) {
            numbers.add(random.nextInt(41) - 20);
        }

        System.out.println("My collection:");
        System.out.println(numbers);

        ArrayList<Integer> uniqueNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (!uniqueNumbers.contains(number)) {
                uniqueNumbers.add(number);
            }
        }

        System.out.println("Collection without duplicates:");
        System.out.println(uniqueNumbers);

        int removedNumbers = numbers.size() - uniqueNumbers.size();
        System.out.println("Amount of deleted duplicates: " + removedNumbers);
    }
}
