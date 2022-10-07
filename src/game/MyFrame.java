package game;

import javax.swing.*;

public class MyFrame extends JFrame {
    MyFrame(MyPanel panel) {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(panel);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
    }
}
