package task2;

public class Book implements Printable {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    Book(String name) {
        this.name = name;
    }

    @Override
    public void print(){
        System.out.println("print book");
    }

    public static void printBooks (Printable[] printable) {
        for (Printable publication : printable) {
            if (publication instanceof Book) {
                System.out.println("book name: " + ((Book) publication).getName());
            }
        }
    }

}