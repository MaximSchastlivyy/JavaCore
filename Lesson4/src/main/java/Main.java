public class Main {

    public static void main(String[] args) {

        PhoneBook phoneBook = new PhoneBook();

        phoneBook.add("Александр", 4564587);
        phoneBook.add("Иван", 8954458);
        phoneBook.add("Сергей", 895213423);
        phoneBook.add("Михаил", 12547896);
        phoneBook.add("Александр", 123334534);
        phoneBook.add("Сергей", 323453453);
        phoneBook.add("Александр", 764535345);
        phoneBook.add("Иван", 678678666);
        phoneBook.add("Александр", 890976677);
        phoneBook.add("Михаил", 55345677);
        phoneBook.add("Александр", 123786786);
        phoneBook.add("Михаил", 75654665);
        phoneBook.add("Иван", 545645676);
        phoneBook.add("Иван", 867867876);
        phoneBook.add("Александр", 444566666);
        phoneBook.add("Сергей", 345345577);

        phoneBook.get("Александр");
        phoneBook.get("Иван");
        phoneBook.get("Сергей");
        phoneBook.get("Михаил");
    }
}
