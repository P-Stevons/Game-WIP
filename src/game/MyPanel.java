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
    Image plat;
    Timer timer;

    int xVelocity = 0;
    int yVelocity = 0;
    int x = 10;
    int y = 10;
    int height = 64;
    int width = 64;
    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        player = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\player.png").getImage();
        backGround = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\backGround.png").getImage();
        plat = new ImageIcon("C:\\Users\\Jupiter2009\\Documents\\Peter\\Git\\game-wip\\src\\game\\images\\plat.png").getImage();

        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g); //Paint backGtounf
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(backGround, 0, 0, null);
        g2D.drawImage(plat, 0, 820, null);
        g2D.drawImage(player, x, y, null);

    }

    @Override
    public void actionPerformed(ActionEvent e) {




        x = x + xVelocity;
        y = y + yVelocity;
        int[] vs = {xVelocity, yVelocity, x, y};
        int[] newVs = Collision.collides(height, width, vs);
        xVelocity = newVs[0];
        yVelocity = newVs[1];
        x = newVs[2];
        y = newVs[3];
        if(!Collision.collides(x,y))
        yVelocity += 1;

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
}

