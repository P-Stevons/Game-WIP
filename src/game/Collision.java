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

    //What if we used setters and getters more. //and also separated the methods further
    public static int[] collides(int logx,int logy, int[] placement){
        int vx = placement[0];
        int vy = placement[1];
        int x = placement[2];
        int y = placement[3];

        if((y+64) > 1024){
           vy = 0;
            y = 1024-64;
        }
        if((x+64) > 1024){
            vx = 0;
            x = 1024-64;
        }
        if(x < 0){
            vx = 0;
            x = 0;
        }
        //collisions with the log
        if((x >= logx)&&((x <= (logx + 330)))) {
            if ((y + 64 >= logy) && (y+64 <= (logy + 55))) {
                vy = 0;
                y = logy - 64;
            }
            if ((y > logy+55) && (y < (logy + 105))){
                vy = 0;
                y = logy+110;
            }
        }

            placement[0] = vx;
            placement[1] = vy;
            placement[2] = x;
            placement[3] = y;

return placement;
    }
    public static boolean collides(int x, int y, int logx, int logy){
        if((y+64) >= 1024){
            return true;
        }
        if(((x >= logx)&&((x < (logx + 330))))&&((y + 64 >= logy) && (y + 64< (logy + 55)))) {
                return true;
            }

        return false;
    }


}

