package pack;

import java.util.*;
public class User {

    private String firstName;
    private String secondName;
    private int age;

    public User(String firstName, String secondName, int age) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
    }

    public User() {

    }

    public int getAge() {
        return age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(firstName, user.firstName) && Objects.equals(secondName, user.secondName);
    }

    //TODO
    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName, age);
    }

    public double calcAverageAge(List<User> userList) {
        OptionalDouble averageAge = userList.stream().mapToDouble(User::getAge).average();
        System.out.println("Average age of users " + averageAge.getAsDouble());

        return averageAge.getAsDouble();
    }

    public List<User> sortByAgeAndFirstName(List<User> userList) {
        System.out.println("Sorted by age and firstName :");
        List<User> otherList = userList.stream()
                .sorted(Comparator.comparing(User::getFirstName))
                .sorted(Comparator.comparingInt(User::getAge))
                .toList();

        otherList.forEach(System.out::println);

        return otherList;
    }

    public List<User> getBySecondName(List<User> userList) {
        if (userList == null) {
            return Collections.emptyList();
        }
        System.out.println("Check users secondName :");
        List<User> otherList = userList.stream().filter(users ->
                users.getSecondName().startsWith("S") ||
                        users.getSecondName().startsWith("A")).toList();

        otherList.forEach(System.out::println);

        return userList.isEmpty() ? List.of() : otherList;
    }


    public List<User> checkAge(List<User> userList) {
        System.out.println("Check users older then 18 :");
        List<User> otherList = userList.stream().filter(users ->
                users.getAge() >= 18).toList();

        otherList.forEach(System.out::println);

        return otherList;
    }

    public List<User> sortByAge(List<User> userList) {
        System.out.println("Sorted by age:");
        List<User> otherList = userList.stream().sorted(Comparator.comparingInt(User::getAge))
                .toList();

        otherList.forEach(System.out::println);
        return otherList;
    }

}
