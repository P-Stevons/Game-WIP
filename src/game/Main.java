package game;
//Main
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
                int logx = panel.getlogx();
                int logy = panel.getlogy();
                int log2x = panel.getlog2x();
                int log2y = panel.getlog2y();

                if (e.getKeyChar() == 'a') {
                    panel.setxVelocity(-7);
                }
                if (e.getKeyChar() == 'd') {
                    panel.setxVelocity(7);
                }
                //Maybe this could be simplified
                if ((e.getKeyChar() == ' ') && ((Collision.collides(panel, logx, logy))|| (Collision.collides(panel, log2x, log2y)))){
                    panel.setyVelocity(-20);

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ((e.getKeyChar() == 'a')||(e.getKeyChar() == 'd')) {
                    panel.setxVelocity(0);
                }


            }
        });
    }
}
