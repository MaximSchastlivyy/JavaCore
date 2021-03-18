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

    public void setWallHeight(int wallHeight) {
        this.wallHeight = wallHeight;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
