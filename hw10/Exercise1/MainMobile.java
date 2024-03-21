package Exercise1;

public class MainMobile {
    public static void main(String[] args) {

        MobilePhone iphone = new Model("iPhone", "13");
        MobilePhone samsung = new Model("Samsung", "Galaxy");
        MobilePhone xiomi = new Model("Xiomi", "x5");


        MobilePhone[] mobilePhones = {iphone, samsung, xiomi};


        for (MobilePhone mobilePhone : mobilePhones) {
            System.out.println(mobilePhone);
            mobilePhone.sms("+380111111111", "Test");
            mobilePhone.call("+380222222222");
            mobilePhone.powerOn();
            mobilePhone.powerOff();

            System.out.println("**********************");
        }
    }
}
