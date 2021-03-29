
public class Main {

    public static void main(String[] args) {

        String[][] array = {{"1", "1", "1", "1"}, {"2", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};
        String[][] array1 = {{"1", "1", "1", "1", "1"}, {"2", "2", "2"}, {"3", "3", "3"}, {"4", "4", "4", "4"}};
        String[][] array2 = {{"1", "1", "1", "1"}, {"asd", "2", "2", "2"}, {"3", "3", "3", "3"}, {"4", "4", "4", "4"}};

        System.out.println("Задание №1:");
        System.out.print("Проверяем 1-й массив: ");
        try {
            System.out.println(arrayLengthCheck(array));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        System.out.print("Проверяем 2-й массив: ");
        try {
            System.out.println(arrayLengthCheck(array1));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }


        System.out.println();
        System.out.println("Задание №2:");

        try {
            System.out.println("Сумма элементов массива: " + arrayNumbersSum(array));
        } catch (MyArrayDataException e) {
            System.out.println("Невозможно вычислить сумму, ошибка в ячейке: " + e.i + "x" + e.j);
        }

        try {
            System.out.println("Сумма элементов массива: " + arrayNumbersSum(array2));
        } catch (MyArrayDataException e) {
            System.out.println("Невозможно вычислить сумму, ошибка в ячейке: " + e.i + "x" + e.j);
        }

    }

    public static boolean arrayLengthCheck(String[][] array) throws MyArraySizeException {
        for (int i = 0; i < array.length; i++) {
            if (array.length != 4 || array[i].length != 4) {
                throw new MyArraySizeException("Размер массива должен быть строго 4х4");
            }
        }
        return true;
    }

    public static int arrayNumbersSum(String[][] array) throws MyArrayDataException {
        int sum = 0;
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    try {
                        sum = sum + Integer.parseInt(array[i][j]);
                    } catch (NumberFormatException e) {
                        throw new MyArrayDataException(i, j);
                    }
                }
            }
            return sum;
    }

}
