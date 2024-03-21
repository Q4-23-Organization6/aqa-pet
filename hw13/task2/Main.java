package task2;

public class Main {

    public static void main(String[] args){

        Book bible = new Book("Bible");
        Magazine cosmopolitan = new Magazine("Cosmopolitan");

        Printable book = bible::print;
        Printable magazine = cosmopolitan::print;

        book.print();
        magazine.print();


        Printable[] printable = {bible, cosmopolitan};


        Book.printBooks(printable);

        Magazine.printMagazines(printable);

    }
}
