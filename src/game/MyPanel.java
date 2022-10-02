package game;
//The actual code
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener {

    final int PANEL_WIDTH = 700;
    final int PANEL_HEIGHT = 700;

    Image enemy;
    Timer timer;

    int xVelocity = 1;
    int yVelocity = 1;
    int x = 10;
    int y = 10;

    MyPanel() {
        this.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
        this.setBackground(Color.black);
        enemy = new ImageIcon("C:\\Users\\Jupiter2009\\Downloads\\Testing\\src\\game\\enemy.png").getImage();
        timer = new Timer(10, this);
        timer.start();
    }

    public void paint(Graphics g) {
        super.paint(g); //Paint backGtounf
        Graphics2D g2D = (Graphics2D) g;
        g2D.drawImage(enemy, x, y, null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {



        x = x + xVelocity;
        y = y + yVelocity;
        repaint();
        int[] vs = {xVelocity, yVelocity};
        int[] newVs = Collision.collides(x, y, vs);
        xVelocity = newVs[0];
        yVelocity = newVs[1];
        if(!Collision.collides(x,y))
        yVelocity ++;
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

