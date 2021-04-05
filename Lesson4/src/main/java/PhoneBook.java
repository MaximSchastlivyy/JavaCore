import java.util.HashMap;
import java.util.HashSet;

public class PhoneBook {

    HashMap<String, HashSet<Integer>> phoneBook1;

    PhoneBook() {
        this.phoneBook1 = new HashMap<>();
    }

    void add(String name, int num1) {
        HashSet<Integer> phoneBook = phoneBook1.getOrDefault(name, new HashSet<>());
        phoneBook.add(num1);
        phoneBook1.put(name, phoneBook);
    }

    void get(String name) {
        System.out.println("Абонент " + name + ": " + phoneBook1.getOrDefault(name, new HashSet<>()));
    }
}
