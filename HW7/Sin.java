public class Sin {
    public static void main(String[] args) {
        double[] array = new double[37];
        int a = 0;

        for (int i = 0; i < array.length; i++) {
            array[i] = Math.sin(a);
            System.out.println("sin(" + a + ") = " + array[i]);

            a = a + 10;
        }
    }
}
