package game;
//makes collisions


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Collision {



    public static void collide(MyPanel panel, int logx, int logy){

        int x = panel.getx();
        int y = panel.gety();
        int xVelocity = panel.getxVelocity();
        int yVelocity = panel.getyVelocity();

        if((y+64) > 1024){
           yVelocity = 0;
            y = 1024-64;
        }
        if((x+64) > 1024){
            xVelocity = 0;
            x = 1024-64;
        }
        if(x < 0){
            xVelocity = 0;
            x = 0;
        }
        //collisions with the log
        if((x >= logx)&&((x <= (logx + 330)))) {
            if ((y + 64 >= logy) && (y+64 <= (logy + 55))) {
                yVelocity = 0;
                y = logy - 64;
            }
            if ((y > logy+55) && (y < (logy + 105))){
                yVelocity = 0;
                y = logy+110;
            }
        }

         panel.setx(x);
        panel.sety(y);
        panel.setxVelocity(xVelocity);
        panel.setyVelocity(yVelocity);


    }
    public static boolean collides(MyPanel panel, int logx, int logy){
        int x = panel.getx();
        int y = panel.gety();
        if((y+64) >= 1024){
            return true;
        }
        if(((x >= logx)&&((x < (logx + 330))))&&((y + 64 >= logy) && (y + 64< (logy + 55)))) {
                return true;
            }

        return false;
    }


}

