package Exercise1;

public class Model extends MobilePhone {
    String model;

    public Model(String name, String model) {
        super(name);
        this.model = model;
    }

    @Override
    public void call(String number) {
        System.out.println("Call to number: " + number);
    }

    @Override
    public void sms(String number, String message) {
        System.out.println("Send message: \"" + message + "\" to " + number);
    }

        @Override
        public String toString () {
            return "Model{" +
                    "name='" + name + '\'' +
                    ", model='" + model + '\'' +
                    "} ";
        }
    }

