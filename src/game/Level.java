package game;

import java.awt.*;

public class Level {
    private final Image image;
    // starting location of key on this level
    final int keyx;
    final int keyy;
    private final boolean hasLeftWall;
    private int bottomHeight;
    private boolean hasRightWall;

    public Level(Image backGround, int keyx, int keyy, int bottomHeight, boolean hasLeftWall, boolean hasRightWall) {
        this.image = backGround;
        this.keyx = keyx;
        this.keyy = keyy;
        this.bottomHeight = bottomHeight;
        this.hasLeftWall = hasLeftWall;
        this.hasRightWall = hasRightWall;
    }

    public void drawImage(Graphics2D g2D) {
        g2D.drawImage(image, 0, 0, null);
    }

    public boolean hasLeftWall() {
        return hasLeftWall;
    }

    public int bottomHeight() {
        return bottomHeight;
    }

    public boolean hasRightWall() {
        return hasRightWall;
    }
}
