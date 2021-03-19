package Homework1;

public class Main {

    public static void main(String[] args) {

        Cat cat1 = new Cat ("Barsik", 100, 50);
        Human human1 = new Human("Ivan", 200, 100);
        Robot robot1 = new Robot("T-100", 300, 200);

        System.out.println("Задание №1:");

        cat1.jump();
        cat1.run();
        human1.run();
        human1.jump();
        robot1.run();
        robot1.jump();

        System.out.println();

        System.out.println("Задание №2:");

        RunRoad runRoad1 = new RunRoad(100);
        Wall wall1 = new Wall(150);

        if (cat1.getMaxSpeed() >= runRoad1.getRunRoadLength()) {
            System.out.println("Кот " + cat1.getName() + " успешно пробежал по беговой дорожке");
        } else {
            System.out.println("Кот " + cat1.getName() + " не смог пробежать по беговой дорожке");
        }

        if (human1.getMaxJump() >= wall1.getWallHeight()) {
            System.out.println("Человек " + human1.getName() + " успешно перепрыгнул стену");
        } else {
            System.out.println("Человек " + human1.getName() + " не смог перепрыгнуть стену");
        }

        System.out.println();

        System.out.println("Задание №3:");

        Cat[] cats = {new Cat("Leopold", 100, 50), new Cat("Barsik", 150, 70)};
        Human[] humans = {new Human("Ivan", 200, 100), new Human("Petr", 220, 150)};
        Robot[] robots = {new Robot("T-100", 300, 200), new Robot("R2D2", 250, 100)};

        RunRoad[] runRoads = {new RunRoad(150, 1), new RunRoad(200, 2)};
        Wall[] walls = {new Wall(100, 1), new Wall(200, 2)};


        for (RunRoad runRoad : runRoads) {
            for (Cat cat : cats) {
                System.out.println("Кот " + cat.getName());
                runRoad.canAnybodyRun(cat);
            }
            for (Human human : humans) {
                System.out.println("Человек " + human.getName());
                runRoad.canAnybodyRun(human);
            }
            for (Robot robot : robots) {
                System.out.println("Робот " + robot.getName());
                runRoad.canAnybodyRun(robot);
            }
        }

        for (Wall wall : walls) {
            for (Cat cat : cats) {
                System.out.println("Кот " + cat.getName());
                wall.canAnybodyJump(cat);
            }
            for (Human human : humans) {
                System.out.println("Человек " + human.getName());
                wall.canAnybodyJump(human);
            }
            for (Robot robot : robots) {
                System.out.println("Робот " + robot.getName());
                wall.canAnybodyJump(robot);
            }
        }
    }
}
