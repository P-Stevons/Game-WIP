package game;
//The actual code
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 1024+ 128;
    final int PANEL_HEIGHT = 1024;

    Image player;
    Image backGround;
    Image log;
    Image log2;
    Image key;
    Image hallways;
    Timer timer;
    int level = 0;
    int xVelocity = 0;
    int yVelocity = 0;
    int x = 10;
    int y = 10;
    int logx = 0;
    int logy = 740;
    int log2x = 500;
    int log2y = 820;
    int keyx = 2000;
    int keyy = 2000;
    int lockx = 615;
    int locky = 0;
    boolean[] hasItems = new boolean[8];

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        player = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\player.png").getImage();
        backGround = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\backGround.png").getImage();
        hallways = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\hallways.png").getImage();
        log = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\log.png").getImage();
        log2 = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\log.png").getImage();
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
        g2D.drawImage(log, logx, logy, null);
        g2D.drawImage(log2, log2x, log2y, null);
        g2D.drawImage(player, x, y, null);
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
        x = x + xVelocity;
        y = y + yVelocity;
        Collision.collide(this, logx, logy);
        Collision.collide(this, log2x, log2y);
        if(!(Collision.collides(this ,logx, logy)||(Collision.collides(this,log2x, log2y)))) {
            yVelocity ++;
        }
        repaint();
    }

    public void level0(){
       logx = 0;
       logy = 740;
       log2x = 500;
       log2y = 820;
       level = 0;
    }
    public void level1(){
         logx = 650;
         logy = 740;
         log2x = 20;
         log2y = 820;
         level = 1;
    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }
    public int getxVelocity() {
        return xVelocity;
    }

    public int getyVelocity() {
        return yVelocity;
    }
    public void setx(int x) {
        this.x = x;
    }

    public void sety(int y) {
        this.y = y;
    }

    public int gety() {
        return y;
    }
    public int getx() {
        return x;
    }
    public int getlogy() {
        return logy;
    }
    public int getlogx() {
        return logx;
    }
    public int getlog2y() {
        return log2y;
    }
    public int getlog2x() {
        return log2x;
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

