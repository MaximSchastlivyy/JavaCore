package Homework1;

public class RunRoad {
    private int runRoadLength;
    private int number;

    public RunRoad(int runRoadLength, int number) {
        this.runRoadLength = runRoadLength;
        this. number = number;
    }

    public RunRoad(int runRoadLength) {
        this.runRoadLength = runRoadLength;
    }

    public int getRunRoadLength() {
        return runRoadLength;
    }

    public void setRunRoadLength(int runRoadLength) {
        this.runRoadLength = runRoadLength;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
