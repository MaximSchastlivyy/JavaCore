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
                if (cat.getMaxSpeed() >= runRoad.getRunRoadLength()) {
                    System.out.println("Кот " + cat.getName() + " успешно пробежал по беговой дорожке №" + runRoad.getNumber());
                } else {
                    System.out.println("Кот " + cat.getName() + " не смог пробежать по беговой дорожке №" + runRoad.getNumber());
                }
            }
            for (Human human : humans) {
                if (human.getMaxSpeed() >= runRoad.getRunRoadLength()) {
                    System.out.println("Человек " + human.getName() + " успешно пробежал по беговой дорожке №" + runRoad.getNumber());
                } else {
                    System.out.println("Человек " + human.getName() + " не смог пробежать по беговой дорожке №" + runRoad.getNumber());
                }
            }
            for (Robot robot : robots) {
                if (robot.getMaxSpeed() >= runRoad.getRunRoadLength()) {
                    System.out.println("Робот " + robot.getName() + " успешно пробежал по беговой дорожке №" + runRoad.getNumber());
                } else {
                    System.out.println("Робот " + robot.getName() + " не смог пробежать по беговой дорожке №" + runRoad.getNumber());
                }
            }
        }

        for (Wall wall : walls) {
            for (Cat cat : cats) {
                if (cat.getMaxJump() >= wall.getWallHeight()) {
                    System.out.println("Кот " + cat.getName() + " успешно перепрыгнул стену №" + wall.getNumber());
                } else {
                    System.out.println("Кот " + cat.getName() + " не смог перепрыгнуть стену №" + wall.getNumber());
                }
            }
            for (Human human : humans) {
                if (human.getMaxJump() >= wall.getWallHeight()) {
                    System.out.println("Человек " + human.getName() + " успешно перепрыгнул стену №" + wall.getNumber());
                } else {
                    System.out.println("Человек " + human.getName() + " не смог перепрыгнуть стену №" + wall.getNumber());
                }
            }
            for (Robot robot : robots) {
                if (robot.getMaxJump() >= wall.getWallHeight()) {
                    System.out.println("Робот " + robot.getName() + " успешно перепрыгнул стену №" + wall.getNumber());
                } else {
                    System.out.println("Робот " + robot.getName() + " не смог перепрыгнуть стену №" + wall.getNumber());
                }
            }
        }


    }
}
