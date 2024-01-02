public class Palindrom {
    public static void main(String[] args) {
        String str = "level";
        char[] result = str.toCharArray();

        int length = result.length;
        boolean palindrome = true;
        for (int i = 0; i < result.length/2; i++) {
            if (result[i] != result[length - i -1])  {
                palindrome = false;
                break;
            }
        }
        if (palindrome) {
            System.out.println("Word " + str + " is a Palindrome");
        } else {
            System.out.println("Word " + str + " is not a Palindrome");
        }
    }
}
