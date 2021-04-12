package Homework1;

public class Human implements CanRun, CanJump {
    private String name;
    private int maxSpeed;
    private int maxJump;

    public Human (String name, int maxSpeed, int maxJump) {
        this.name = name;
        this.maxSpeed = maxSpeed;
        this.maxJump = maxJump;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public int getMaxJump() {
        return maxJump;
    }

    public void setMaxJump(int maxJump) {
        this.maxJump = maxJump;
    }

   //@Override
   //public void run(){
   //    System.out.println("Человек пробежал");
   //}

   //@Override
   //public void jump() {
   //    System.out.println("Человек прыгнул");
   //}

    public void run(int length) {
        if (getMaxSpeed() >= length) {
            System.out.println("Человек " + getName() + " успешно пробежал по дорожке!");
        } else {
            System.out.println("Человек " + getName() + " не смог пробежать по дорожке!");
        }
    }

    @Override
    public void jump(int height) {
        if (getMaxSpeed() >= height) {
            System.out.println("Человек " + getName() + " успешно перепрыгнул стену!");
        } else {
            System.out.println("Человек " + getName() + " не смог перепрыгнуть стену!");
        }
    }
}
