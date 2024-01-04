public class MinMaxValue {
    public static void main(String[] args) {
        int[] numbers = {20, 35, 61, -55, 28, 44, 99, 4};
        int max = 0;
        int min = 0;
        for( int i = 0; i < numbers.length; i++){
            if ( numbers[i] > max){
                max = numbers[i];
            }
            else if (numbers[i] < min){
                min = numbers[i];
            }
        }
        System.out.println("Minimum: " + min + " . " + "Maximum: " + max);

    }
}
