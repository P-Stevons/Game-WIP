package game;
//makes collisions


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


public class Collision extends KeyAdapter {

    public static int[] collides(int height,int width, int[] vs){
        if((vs[3]+height) > 1024){
            vs[1] = 0;
            vs[3] = 1024-height;
        }
        if((vs[2]+width) > 1024){
            vs[0] = 0;
            vs[2] = 1024-width;
        }
        if(vs[2] < 0){
            vs[0] = 0;
            vs[2] = 0;
        }

return vs;
    }
    public static boolean collides(int x, int y){
        if((y+100) >= 1024){
            return true;
        }
        return false;
    }


}

