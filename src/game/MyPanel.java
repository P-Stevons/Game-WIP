package game;
//The actual code
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 1024+ 128;
    final int PANEL_HEIGHT = 1024;

    Player player;
    Image backGround;
    Log log;
    Log log2;
    Image key;
    Image hallways;
    Timer timer;
    int level = 0;
    int keyx = 2000;
    int keyy = 2000;
    int lockx = 615;
    int locky = 0;
    boolean[] hasItems = new boolean[8];

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        player = new Player(10, 10);
        backGround = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\backGround.png").getImage();
        hallways = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\hallways.png").getImage();
        // TODO this becomes
        // log = new Log(0, 740)
        log = new Log(0, 740);
        log2 = new Log(500, 820);
        key = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\key.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g); //Paint backGtounf
        Graphics2D g2D = (Graphics2D) g;
        if(level == 0) {
            g2D.drawImage(backGround, 0, 0, null);
        } else {
            g2D.drawImage(hallways, 0, 0, null);
        }

        log.draw(g2D);
        log2.draw(g2D);
        player.draw(g2D);
        g2D.drawImage(key, keyx, keyy, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(hasItems[0]){
            keyx = 1024 + 32;
            keyy = 32;
        } else if(level == 1){
             keyx = 200;
             keyy = 520;
        } else {
            keyx = 2000;
            keyy = 2000;
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
       level = 0;
    }
    public void level1(){
        log.moveTo(650, 740);
        log2.moveTo(20, 820);
         level = 1;
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
    public int getlevel() {
        return level;
    }
    public int getKeyx() {
        return keyx;
    }
    public int getKeyy() {
        return keyy;
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
}

