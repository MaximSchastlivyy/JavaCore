import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

public class ArraysOfCars {

    public static void main(String[] args) {

        ArrayList<String> cars = new ArrayList<>();

        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Audi");
        cars.add("Honda");
        cars.add("Toyota");
        cars.add("Volkswagen");
        cars.add("Audi");
        cars.add("Toyota");
        cars.add("Mercedes");
        cars.add("BMW");
        cars.add("Volkswagen");
        cars.add("Toyota");
        cars.add("BMW");
        cars.add("Honda");
        cars.add("BMW");
        cars.add("Mercedes");
        cars.add("Honda");

        System.out.println("Все марки машин:");
        System.out.println(cars);

        Set<String> stringSet = new LinkedHashSet<>(cars);
        System.out.println();
        System.out.println("Уникальные марки машин");
        System.out.println(stringSet);

        HashMap<String, Integer> repeatNameOfCars = new HashMap<>();
        Integer repeatNameOfCar = null;
        for (String i : cars) {
            repeatNameOfCar = repeatNameOfCars.get(i);
            repeatNameOfCars.put(i, repeatNameOfCar == null ? 1 : repeatNameOfCar + 1);
        }

        System.out.println();
        System.out.println("Количество машин каждой марки:");
        System.out.println(repeatNameOfCars);

    }
}
