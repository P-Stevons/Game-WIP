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


    public static void collide(MyPanel panel, int logx, int logy) {

        Level level = panel.getLevel();
        int x = panel.getx();
        int y = panel.gety();
        int xVelocity = panel.getxVelocity();
        int yVelocity = panel.getyVelocity();
        int bottomHeight = level.bottomHeight();

        if ((y + 64) > level.bottomHeight()) {
            yVelocity = 0;
            y = bottomHeight - Player.HEIGHT;
        }

        if ((x + Player.WIDTH) > MyPanel.GAME_AREA_WIDTH) {
            xVelocity = 0;
            x =  MyPanel.GAME_AREA_WIDTH - 64;
            if (!level.hasRightWall()) {
                panel.incrementLevel();
                x = 0;
            }
        }
        if (x < 0) {
            xVelocity = 0;
            x = 0;
            if (!level.hasLeftWall()) {
                panel.decrementLevel();
                x = MyPanel.GAME_AREA_WIDTH - Player.WIDTH;
            }
        }
        //collisions with the log
        if ((x + Player.WIDTH >= logx) && ((x <= (logx + Log.WIDTH)))) {
            if ((y + Player.HEIGHT >= logy) && (y + Player.HEIGHT <= (logy + 55))) {
                yVelocity = 0;
                y = logy - Player.HEIGHT;
            }
            if ((y > logy + 55) && (y < (logy + 105))) {
                yVelocity = 0;
                y = logy + Log.HEIGHT;
            }
        }

        panel.setx(x);
        panel.sety(y);
        panel.setxVelocity(xVelocity);
        panel.setyVelocity(yVelocity);


    }

    public static boolean collides(MyPanel panel, int logx, int logy) {
        int x = panel.getx();
        int y = panel.gety();
            if ((y + Player.HEIGHT) >= panel.getLevel().bottomHeight()) {
                return true;
            }
        if (((x + Player.WIDTH >= logx) && ((x < (logx + Log.WIDTH)))) && ((y + Player.HEIGHT >= logy) && (y + Player.HEIGHT < (logy + Log.HEIGHT/2)))) {
            return true;
        }

        return false;
    }

    public static boolean collidesKey(MyPanel panel, int keyx, int keyy) {
        int x = panel.getx();
        int y = panel.gety();
        if ((x + 64 >= keyx) && (x <= keyx + 64) && (y + 64 >= keyy) && (y <= keyy + 64))
            return true;
        return false;
    }

    public static boolean collidesLock(MyPanel panel, int lockx, int locky) {
        int x = panel.getx();
        int y = panel.gety();
        if ((x + 64 >= lockx) && (x <= lockx + 205) && (y + 64 >= locky) && (y <= locky + 600))
            return true;
        return false;
    }


}

