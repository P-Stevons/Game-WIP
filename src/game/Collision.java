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
//vx, vy, x, y, logx, logy
    public static int[] collides(int height,int width, int[] placement){
        int vx = placement[0];
        int vy = placement[1];
        int x = placement[2];
        int y = placement[3];
        int logx = placement[4];
        int logy = placement[5];
        if((y+height) > 1024){
           vy = 0;
            y = 1024-height;
        }
        if((x+width) > 1024){
            vx = 0;
            x = 1024-width;
        }
        if(x < 0){
            vx = 0;
            x = 0;
        }
        //collisions with the log
        if((x >= logx)&&((x <= (logx + 330)))) {
            if ((y + height >= logy) && (y+height <= (logy + 55))) {
                vy = 0;
                y = logy - height;
            }
        }

            placement[0] = vx;
            placement[1] = vy;
            placement[2] = x;
            placement[3] = y;
            placement[4] = logx;
            placement[5] = logy;

return placement;
    }
    public static boolean collides(int x, int y, int logx, int logy){
        if((y+100) >= 1024){
            return true;
        }
        if((x >= logx)&&((x < (logx + 330)))) {
            if ((y + 64 >= logy) && (y + 64<= (logy + 55))) {
                return true;
            }
        }
        return false;
    }


}

