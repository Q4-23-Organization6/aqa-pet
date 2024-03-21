package task1;

public class Magazine implements Printable {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    Magazine(String name) {
        this.name = name;
    }

    @Override
    public void print(){
        System.out.println("print magazine");
    }

    public static void printMagazines (Printable[] printable) {
        for (Printable publication : printable) {
            if (publication instanceof Magazine) {
                System.out.println("magazine name: " + ((Magazine) publication).getName());
            }
        }
    }
}