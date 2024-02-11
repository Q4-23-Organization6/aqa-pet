package task1;

public class Main {

    public static void main(String[] args){

        Book bible = new Book("Bible");
        Magazine cosmopolitan = new Magazine("Cosmopolitan");

        Printable book = () -> System.out.println("Printing a book with lambda expression");
        Printable magazine = () -> System.out.println("Printing a magazine with lambda expression");

        book.print();
        magazine.print();

        Printable[] printable = {bible, cosmopolitan};


        Book.printBooks(printable);

        Magazine.printMagazines(printable);

    }
}