import java.util.Scanner;

public class Calculator {
    public static int add(int a, int b) {
        return a + b;
    }
        public static int subtract(int a, int b) {
            return a - b;
        }

        public static int multiply(int a, int b) {
            return a * b;
        }

        public static double divide(double a, double b) {
            if (b == 0) {
                System.out.println("Error: Cannot divide by zero");
                return Double.NaN;
            }
            return a / b;
        }
    }


