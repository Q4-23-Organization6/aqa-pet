package task3;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        List<User> userList = Arrays.asList(
                new User("Bob", "Sinclar", 54),
                new User("Charlie", "Sheen", 58),
                new User("Miley", "Syrus", 31),
                new User("Victoria", "Beckham", 49),
                new User("Patrick", "Adams", 42));


        System.out.println("Sorted by age:");
        List<User> otherList = userList.stream().sorted(Comparator.comparingInt(User::getAge))
                .toList();

        otherList.forEach(System.out::println);
        System.out.println("**********");


        OptionalDouble averageAge = userList.stream().mapToDouble(User::getAge).average();
        System.out.println("Average age of users " + averageAge.getAsDouble());
        System.out.println("**********");


        System.out.println("Sorted by age and firstName:");
        userList.stream()
                .sorted(Comparator.comparing(User::getFirstName))
                .sorted(Comparator.comparingInt(User::getAge))
                .toList().forEach(System.out::println);

        System.out.println("**********");


        System.out.println("Check users secondName:");
        userList.stream().filter(users ->
                users.getSecondName().startsWith("S") ||
                        users.getSecondName().startsWith("A")).toList().forEach(System.out::println);

        System.out.println("**********");

        //Перевірити чи всі юзери старше 18 років
        System.out.println("Check users older then 18:");
        userList.stream().filter(users ->
                users.getAge() >= 18).toList().forEach(System.out::println);
    }
}
