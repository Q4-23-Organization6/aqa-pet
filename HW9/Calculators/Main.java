package Calculators;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Simple simpleCalculator = new Simple();

        Engineering engineeringCalculator = new Engineering();

        Programming programmingCalculator = new Programming();


        System.out.print("Enter the first number: ");

        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");

        int num2 = scanner.nextInt();


        System.out.println("Sum: " + simpleCalculator.add(num1, num2));

        System.out.println("Difference: " + simpleCalculator.subtract(num1, num2));

        System.out.println("Product: " + simpleCalculator.multiply(num1, num2));

        System.out.println("Part: " + simpleCalculator.divide(num1, num2));

        System.out.print("Enter a number to calculate the square root of: ");


        double sqrtInput = scanner.nextDouble();

        System.out.println("Square root: " + engineeringCalculator.squareRoot(sqrtInput));

        System.out.print("Enter a number to calculate the degree: ");


        double base = scanner.nextDouble();

        System.out.print("Enter the degree: ");


        double exponent = scanner.nextDouble();

        System.out.println("Raised to the degree: " + engineeringCalculator.power(base, exponent));


        System.out.print("Enter a number to store in memory: ");


        double memoryValue = scanner.nextDouble();

        programmingCalculator.storeInMemory(memoryValue);

        System.out.println("Values in memory: " + programmingCalculator.recallFromMemory());

        scanner.close();
    }
}
