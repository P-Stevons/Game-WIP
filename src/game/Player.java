package game;

public class Player extends Drawable {
    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    int xVelocity;
    int yVelocity;

    public Player(int startX, int startY) {
        super("player.png", WIDTH, HEIGHT, startX, startY);
    }

    public void moveFromVelocity() {
        moveFromVelocity(xVelocity, yVelocity);
    }

    // TODO this wont work until somebody calls this
    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }
    public void fall(){
        this.yVelocity = yVelocity + 1;
    }
}


