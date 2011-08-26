package com.barabatz.firstrts.texture;

import com.barabatz.firstrts.GameStarter;
import org.lwjgl.opengl.GL11;

/**
 * Created by IntelliJ IDEA.
 * User: bobaffe
 * Date: 26.08.11
 * Time: 01:42
 */
public class SquareEntity {
    private int x = 100;
    private int y = 100;
    private int size = 200;

    public void draw(){
        // Clear the screen and the depth buffer
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        //Set quad color (R,G,B)
        GL11.glColor3f(0.5f, 0.8f, 1.0f);

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
