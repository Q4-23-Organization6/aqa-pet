package Exercise2;

public class Main {
    public static void main(String[] args) {
        Book book = new Book("Bible");
        Book book2 = new Book("Dictionary");

        Magazine magazine = new Magazine("Time");
        Magazine magazine2 = new Magazine("Cosmopolitan");

        Printable[] printable = {book, book2, magazine, magazine2};

        for (Printable item : printable) {
            item.print();

            System.out.println("-----");
        }

        System.out.println("********");
        Magazine.printMagazines(printable);

        System.out.println("********");
        Book.printBooks(printable);
    }
}
