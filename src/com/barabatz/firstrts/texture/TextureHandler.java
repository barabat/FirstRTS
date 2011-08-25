package com.barabatz.firstrts.texture;

import com.barabatz.firstrts.GameStarter;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.Display;

import javax.print.attribute.Size2DSyntax;

/**
 * Created by IntelliJ IDEA.
 * User: bobaffe
 * Date: 26.08.11
 * Time: 00:42
 */
public class TextureHandler {
    private int x = 100;
    private int y = 100;
    private int size = 200;

    public TextureHandler() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, GameStarter.WINDOW_WIDTH,GameStarter.WINDOW_HEIGHT,0,1,-1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    public void draw() {
        // Clear the screen and the depth buffer
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        //Set quad color (R,G,B)
        GL11.glColor3f(0.5f, 0.5f, 1.0f);

        //Draw a quad
        GL11.glBegin(GL11.GL_QUADS);


        GL11.glVertex2f(x,y);
        GL11.glVertex2f(x+size, y);
        GL11.glVertex2f(x+size, y+size);
        GL11.glVertex2f(x, y+size);
        GL11.glEnd();
    }

    public void moveRight() {
        x++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public void setItemInMiddle() {
        x= GameStarter.WINDOW_WIDTH/2 - size/2;
        y= GameStarter.WINDOW_HEIGHT/2 - size/2;
    }
}
