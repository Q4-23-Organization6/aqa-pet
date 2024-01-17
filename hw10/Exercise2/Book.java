package Exercise2;

public class Book implements Printable {
    private String title;

    public Book(String title) {
        this.title = title;
    }

    public static void printBooks(Printable[] printables) {
        for (Printable printable : printables) {
            if (printable instanceof Book) {
                Book book = (Book) printable;
                System.out.println("Book: " + book.title);
            }
        }
    }

    @Override
    public void print() {
        System.out.println("Book: " + title);
    }
}

