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
        jumper.jump(wallHeight);
    }
}
