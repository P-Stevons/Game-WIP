import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MyPanel extends JPanel implements ActionListener{

    final int PANEL_WIDTH = 500;
    final int PANEL_HEIGHT = 500;
    Image enemy;
    Timer timer;
    int xVelocity;
    int yVelocity;
    int x = 10;
    int y = 10;

    MyPanel(){

        this.setPreferredSize(new Dimension(PANEL_WIDTH,PANEL_HEIGHT));
        this.setBackground(Color.black);
        enemy = new ImageIcon("C:\\Users\\Jupiter2009\\Downloads\\Testing\\src\\game\\enemy.png").getImage();
        timer = new Timer(1, this);
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
        repaint();
    }
}
