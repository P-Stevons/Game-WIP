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

    public static int[] collides(int x, int y, int[] vs){
        if(y > 300){
            vs[1] = 0;
        }
return vs;
    }
    public static boolean collides(int x, int y){
        if(y > 300){
            return true;
        }
        return false;
    }


}

