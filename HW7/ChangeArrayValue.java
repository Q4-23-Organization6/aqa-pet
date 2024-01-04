import java.util.Random;
public class ChangeArrayValue {
    public static void main(String[] args) {
        int[] arrayValue = new int[10];
        Random rnd = new Random();
        for(int i = 0; i < arrayValue.length; i++) {
            arrayValue[i] = rnd.nextInt(100);
            int result = (arrayValue[i] % 2);
            if (result == 0) {
                arrayValue[i] = 0;
            }
            System.out.println(arrayValue[i]);
        }

    }
}
