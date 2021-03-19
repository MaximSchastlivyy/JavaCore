package Homework1;

public class Wall {
    private int wallHeight;
    private int number;

    public Wall(int wallHeight, int number) {
        this.wallHeight = wallHeight;
        this.number = number;
    }
    public Wall(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    public int getWallHeight() {
        return wallHeight;
    }

    public void canAnybodyJump (CanJump jumper) {
        if (jumper.anybodyJump() >= wallHeight) {
            System.out.println("Успешно перепрыгнул стену №" + number);
        } else {
            System.out.println("Не смог перепрыгнуть стену №" + number);
        }
    }
}
