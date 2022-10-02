package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

class Main {
    public static void main(String[] args) {
        MyPanel panel = new MyPanel();
        MyFrame frame = new MyFrame(panel);

        frame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyChar() == 'w') {
                    panel.setyVelocity(-1);
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
}
