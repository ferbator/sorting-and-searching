import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Тестирование Arrays
        testPrimitiveArrays();
        testGenericArrays();

        // Тестирование Collections
        testCollections();
    }

    private static void testPrimitiveArrays() {
        System.out.println("=== Testing Arrays with Primitive Types ===");

        // Тестирование с byte
        byte[] byteArray = {1, 3, 5, 7, 9};
        System.out.println("byte[] binarySearch: " + Arrays.binarySearch(byteArray, (byte) 5)); // Ожидается: 2
        System.out.println("byte[] binarySearch (not found): " + Arrays.binarySearch(byteArray, (byte) 6)); // Ожидается: -4

        // Тестирование с char
        char[] charArray = {'a', 'c', 'e', 'g'};
        System.out.println("char[] binarySearch: " + Arrays.binarySearch(charArray, 'c')); // Ожидается: 1
        System.out.println("char[] binarySearch (not found): " + Arrays.binarySearch(charArray, 'f')); // Ожидается: -4

        // Тестирование с double
        double[] doubleArray = {1.1, 2.2, 3.3, 4.4};
        System.out.println("double[] binarySearch: " + Arrays.binarySearch(doubleArray, 3.3)); // Ожидается: 2
        System.out.println("double[] binarySearch (not found): " + Arrays.binarySearch(doubleArray, 5.5)); // Ожидается: -5
    }

    private static void testGenericArrays() {
        System.out.println("\n=== Testing Arrays with Generics ===");

        // Тестирование generic-массивов
        String[] stringArray = {"apple", "banana", "cherry", "date"};
        System.out.println("Generic binarySearch: " + Arrays.binarySearch(stringArray, "banana", String::compareTo)); // Ожидается: 1
        System.out.println("Generic binarySearch (not found): " + Arrays.binarySearch(stringArray, "fig", String::compareTo)); // Ожидается: -4

        // Тестирование с компаратором
        Person[] peopleArray = {
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        };

        // Сортировка массива
        java.util.Arrays.sort(peopleArray, Comparator.comparing(Person::name));

        Person searchPerson = new Person("Bob", 0); // Для поиска только имя
        System.out.println("Custom Comparator binarySearch: " + Arrays.binarySearch(peopleArray, searchPerson, Comparator.comparing(Person::name))); // Ожидается: 1
    }

    private static void testCollections() {
        System.out.println("\n=== Testing Collections ===");

        // Создаем список и сортируем
        List<Integer> intList = new ArrayList<>(List.of(10, 20, 30, 40, 50));
        Collections.sort(intList);
        System.out.println("List binarySearch: " + Collections.binarySearch(intList, 30)); // Ожидается: 2
        System.out.println("List binarySearch (not found): " + Collections.binarySearch(intList, 25)); // Ожидается: -3

        // Список объектов
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Alice", 30));
        personList.add(new Person("Charlie", 35));
        personList.add(new Person("Bob", 25));

        // Сортировка списка по имени
        personList.sort(Comparator.comparing(Person::name));

        // Поиск объекта
        Person searchPerson = new Person("Charlie", 0); // Поиск по имени
        System.out.println("Custom Comparator binarySearch: " + Collections.binarySearch(personList, searchPerson, Comparator.comparing(Person::name))); // Ожидается: 2
    }
}

record Person(String name, int age) {
}
