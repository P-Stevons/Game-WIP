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

                if (e.getKeyChar() == 'a') {
                    panel.setxVelocity(-1);
                }
                if (e.getKeyChar() == 'd') {
                    panel.setxVelocity(1);
                }
                if ((e.getKeyChar() == ' ') && (Collision.collides(panel.getx(), panel.gety()))) {
                    panel.setyVelocity(-10);

                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                panel.setyVelocity(0);
                panel.setxVelocity(0);
            }
        });
    }
}
