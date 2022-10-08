package game;

public class Player extends Drawable {
    int xVelocity;
    int yVelocity;

    public Player(int startX, int startY) {
        super("player.png", 64, 64, startX, startY);
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


