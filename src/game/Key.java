package game;

public class Key extends Drawable {

    public static final int WIDTH = 64;
    public static final int HEIGHT = 64;
    public boolean collected;

    public Key(int startX, int startY) {
        super("key.png", WIDTH, HEIGHT, startX, startY);
    }
}


