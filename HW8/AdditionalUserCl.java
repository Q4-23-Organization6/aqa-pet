public class AdditionalUserCl {
    public static void main(String[] args) {
        User user1 = new User("Admin", "pass123");
        User user2 = new User("User", "test123");
        User user3 = new User("Client");

        user1.setAge(20);
        user2.setAge(30);
        user3.setAge(40);

        user1.setEmail("admin@gmail.com");
        user2.setEmail("user@gmail.com");
        user3.setEmail("client@gmail.com");

        user1.makePurchase(55.67);
        user2.makePurchase(86.12);
        user3.makePurchase(154.50);

        user1.printTotalAmountOfSpentMoney();
        user2.printTotalAmountOfSpentMoney();
        user3.printTotalAmountOfSpentMoney();
    }

}
