package pack;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ValidateUsersTest {
    private static List<User> userList;


    @BeforeAll
    static void ListUser() {
        userList = Arrays.asList(
                new User("Bob", "Sinclar", 54),
                new User("Charlie", "Sheen", 58),
                new User("Miley", "Syrus", 31),
                new User("Victoria", "Beckham", 49),
                new User("Patrick", "Adams", 42));
    }

    @BeforeEach
    void setUp() {
        System.out.println("Start tests");

    }

    @AfterAll
    static void tearDown() {
        System.out.println("Finish tests");
    }

    @AfterEach
    public void printDelimiter() {
        System.out.println("******************");
    }

    @Test
    void testUserListSize() {
        assertEquals(5, userList.size());
    }

    @Test
    void testCalcAverageAge() {
        User user = new User("John", "Doe", 25);
        double averageAge = user.calcAverageAge(userList);
        assertEquals(46.8, averageAge);
    }

    @Test
    void testCalcAverageAgeReturnType() {
        User user = new User("John", "Doe", 25);
        double averageAge = user.calcAverageAge(userList);
        assertTrue(Double.class.isAssignableFrom(Double.valueOf(averageAge).getClass()));
    }

    @Test
    void testSortByAgeAndFirstNameReturnType() {
        User user = new User("John", "Doe", 25);
        List<User> sortedList = user.sortByAgeAndFirstName(userList);
        assertTrue(sortedList instanceof List);
    }

    @Test
    void testSortByAgeAndFirstName() {
        User user = new User("John", "Doe", 25);
        List<User> sortedList = user.sortByAgeAndFirstName(userList);
        assertEquals("Miley", sortedList.get(0).getFirstName());
        assertEquals("Syrus", sortedList.get(0).getSecondName());
        assertEquals(31, sortedList.get(0).getAge());
    }

    @Test
    void testGetBySecondName() {
        User user = new User("John", "Doe", 25);
        List<User> filteredList = user.getBySecondName(userList);

        assertFalse(filteredList.isEmpty());

        for (User u : filteredList) {
            assertTrue(u.getSecondName().startsWith("S") || u.getSecondName().startsWith("A"));
        }
    }

    @Test
    void testCheckAge() {
        User user = new User("John", "Doe", 25);
        List<User> filteredList = user.checkAge(userList);

        assertFalse(filteredList.isEmpty());

        for (User u : filteredList) {
            assertTrue(u.getAge() >= 18);
        }
    }

    @Test
    void testSortByAge() {
        User user = new User("John", "Doe", 25);
        List<User> sortedList = user.sortByAge(userList);

        assertFalse(sortedList.isEmpty());

        for (int i = 1; i < sortedList.size(); i++) {
            assertTrue(sortedList.get(i - 1).getAge() <= sortedList.get(i).getAge());
        }
    }

    @Test
    void testUsersWithSorA() {
        List<User> filteredList = userList.stream().filter(user -> user.getSecondName().startsWith("S") || user.getSecondName().startsWith("A")).toList();

        assertFalse(filteredList.isEmpty());

        for (User u : filteredList) {
            assertTrue(u.getSecondName().startsWith("S") || u.getSecondName().startsWith("A"));
        }
    }

    @Test
    void testGetBySecondName_NullInputList() {
        List<User> result = new User().getBySecondName(null);
        assertNotNull(result);
        assertTrue(result.isEmpty());
    }

    @ParameterizedTest
    @MethodSource("provideAges")
    void testCheckAge(int age) {
        List<User> olderUsers = new User().checkAge(userList);

        for (User user : olderUsers) {
            assertEquals(user.getAge() >= age, true);
        }
    }

    static Stream<Arguments> provideAges() {
        return Stream.of(
                arguments(18),
                arguments(30),
                arguments(20),
                arguments(25)
        );
    }
}