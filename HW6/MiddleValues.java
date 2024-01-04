

public class MiddleValues {
    public static void main(String[] args) {
        System.out.println("Strings");
        String averageOne = "Test";
        int position1 = averageOne.length() / 2 - 1;
        int position2 = averageOne.length() / 2 + 1;
        System.out.println(averageOne.substring(position1, position2));
    }
}