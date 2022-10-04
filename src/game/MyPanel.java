package game;
//The actual code
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 1024;
    final int PANEL_HEIGHT = 1024;

    Image player;
    Image backGround;
    Image log;
    Image log2;
    Timer timer;

    int xVelocity = 0;
    int yVelocity = 0;
    int x = 10;
    int y = 10;
    int logx = 0;
    int logy = 740;
    int log2x = 500;
    int log2y = 820;
    int height = 64;
    int width = 64;
    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        player = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\player.png").getImage();
        backGround = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\backGround.png").getImage();
        log = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\log.png").getImage();
        log2 = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\log.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g); //Paint backGtounf
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backGround, 0, 0, null);
        g2D.drawImage(log, logx, logy, null);
        g2D.drawImage(log2, log2x, log2y, null);
        g2D.drawImage(player, x, y, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        x = x + xVelocity;
        y = y + yVelocity;
        int[] toCol = {xVelocity, yVelocity, x, y};
        toCol = Collision.collides(logx, logy, toCol);
        toCol = Collision.collides(log2x, log2y, toCol);
        xVelocity = toCol[0];
        yVelocity = toCol[1];
        x = toCol[2];
        y = toCol[3];
        if(!(Collision.collides(x,y,logx, logy)||(Collision.collides(x,y,log2x, log2y)))) {
            yVelocity ++;
        }
        repaint();

    }

    public void setxVelocity(int xVelocity) {
        this.xVelocity = xVelocity;
    }

    public void setyVelocity(int yVelocity) {
        this.yVelocity = yVelocity;
    }


    public int gety() {
        return y;
    }
    public int getx() {
        return x;
    }
    public int getLogx() {
        return logx;
    }
    public int getLogy() {
            return logy;
    }
    public int getLog2x() {
        return log2x;
    }
    public int getLog2y() {
        return log2y;
    }
}

