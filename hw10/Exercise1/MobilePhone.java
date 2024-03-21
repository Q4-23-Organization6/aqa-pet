package Exercise1;

    public abstract class MobilePhone implements Mobile {

        String name;

        public MobilePhone(String name) {
            this.name = name;
        }

        public void powerOn() {
            System.out.println(name + " start mode!");
        }

        public void powerOff() {
            System.out.println(name + " turn off mode!");
        }

    }

