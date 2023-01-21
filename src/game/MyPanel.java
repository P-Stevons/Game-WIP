package game;
//The actual code
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener {

    public static final int TOOLBAR_WIDTH = 128;
    public static final int GAME_AREA_WIDTH = 1024;
    final int PANEL_WIDTH = GAME_AREA_WIDTH + TOOLBAR_WIDTH;
    final int PANEL_HEIGHT = 1024;

    Player player;
    Image backGround;
    Log log;
    Log log2;
    Key key;
    Image hallways;
    Timer timer;
    Level[] levels = new Level[2];
    int levelIndex;
    int lockx = 615;
    int locky = 0;
    boolean[] hasItems = new boolean[8];

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        player = new Player(10, 10);
        initializeLevels();

        levelIndex = 0;
        // TODO this becomes
        // log = new Log(0, 740)
        log = new Log(0, 740);
        log2 = new Log(500, 820);
        key = new Key(2000, 2000);
        timer = new Timer(10, this);
        timer.start();
    }

    private void initializeLevels() {
        backGround = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\backGround.png").getImage();
        hallways = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\hallways.png").getImage();

        levels[0] = new Level(backGround, 2000, 2000, 1024, true, false);
        levels[1] = new Level(hallways, 200, 520, 600, false, true);
    }

    public void paint(Graphics g) {
        super.paint(g); //Paint backGtounf
        Graphics2D g2D = (Graphics2D) g;
        getLevel().drawImage(g2D);

        log.draw(g2D);
        log2.draw(g2D);
        player.draw(g2D);
        key.draw(g2D);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(key.collected){
           key.moveTo(1024+32, 32);
        } else {
            key.moveTo(getLevel().keyx, getLevel().keyy);
        }
       player.moveFromVelocity();
        Collision.collide(this, log.x, log.y);
        Collision.collide(this, log2.x, log2.y);
        if(!(Collision.collides(this ,log.x, log.y)||(Collision.collides(this,log2.x, log2.y)))) {

        }
        player.fall();

        repaint();
    }

    public void level0(){
       log.moveTo(0, 740);
       log2.moveTo(500, 820);
       levelIndex = 0;
    }
    public void level1(){
        log.moveTo(650, 740);
        log2.moveTo(20, 820);
         levelIndex = 1;
    }

    public void setxVelocity(int xVelocity) {
        player.xVelocity = xVelocity;
    }

    public void setyVelocity(int yVelocity) {
        player.yVelocity = yVelocity;
    }
    public int getxVelocity() {
        return player.xVelocity;
    }

    public int getyVelocity() {
        return player.yVelocity;
    }
    public void setx(int x) {
        player.x = x;
    }

    public void sety(int y) {
        player.y = y;
    }

    public int gety() {
        return player.y;
    }
    public int getx() {
        return player.x;
    }
    public int getlogy() {
        return log.y;
    }
    public int getlogx() {
        return log.x;
    }
    public int getlog2y() {
        return log2.y;
    }
    public int getlog2x() {
        return log2.x;
    }
    public Level getlevel() {
        return levels[levelIndex];
    }
    public int getKeyx() {
        return key.x;
    }
    public int getKeyy() {
        return key.y;
    }

    public boolean[] getHasItems() {
        return hasItems;
    }

    public void setHasItems(boolean[] hasItems) {
        this.hasItems = hasItems;
    }
    public int getLockx() {
        return lockx;
    }

    public int getLocky() {
        return locky;
    }

    public Level getLevel() {
        return levels[levelIndex];
    }

    public void incrementLevel() {
        ++levelIndex;
        System.out.println("NEW LEVEL: " + levelIndex);
    }

    public void decrementLevel() {
        --levelIndex;
        System.out.println("NEW LEVEL: " + levelIndex);
    }
}

