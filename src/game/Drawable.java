package game;

import javax.swing.*;
import java.awt.*;

public abstract class Drawable {
    static final String IMAGE_PATH = "C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\";
    final Image image;
    final int width;
    final int height;
    // TODO make private
    int x;
    int y;

    protected Drawable(String imageName, int width, int height, int startX, int startY) {
        this.image = new ImageIcon(IMAGE_PATH + imageName).getImage();;
        this.width = width;
        this.height = height;
        this.x = startX;
        this.y = startY;
    }

    public void draw(Graphics2D g2D) {
        g2D.drawImage(image, x, y, null);
    }

    public void moveTo(int newX, int newY) {
        x = newX;
        y = newY;
    }


    public void moveFromVelocity(int xVelocity, int yVelocity) {
        moveTo(x + xVelocity, y + yVelocity);
    }

    /**
     *
     * @param other
     * @return true if this drawable overlaps with the other drawable
     */
    public boolean collidesWith(Drawable other) {
        return true;
    }

    /**
     * If I collide with the other drawable, then move me so I don't.
     * @param other
     */
    public void collide(Drawable other) {

    }
}
