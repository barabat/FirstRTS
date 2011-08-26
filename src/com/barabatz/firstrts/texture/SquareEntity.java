package com.barabatz.firstrts.texture;

import com.barabatz.firstrts.GameStarter;
import org.lwjgl.opengl.*;

/**
 * Created by IntelliJ IDEA.
 * Date: 26.08.11
 * Time: 01:42
 */
public class SquareEntity {
    private int x = 100;
    private int y = 100;
    private int size = 50;
    private float rotation = 0f;
    private int delta;
    private float rotationSpeed = 0f;

    public void draw(int delta){
        this.delta = delta;
        setRotation();
        System.out.println("X: " +x+ " Rot: " + rotation);
        keepOnScreen();
        // Clear the screen and the depth buffer
        GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);

        float B = 0f;
        //Set quad color (R,G,B)
        GL11.glColor3f(calculateRColor(), calculateGColor(), B);

        //Draw a quad
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, 0);
        GL11.glRotatef(rotation, 0f, 0f, 1f);
        GL11.glTranslatef(-x, -y, 0);

        GL11.glBegin(GL11.GL_QUADS);
        GL11.glVertex2f(x-size,y-size);
        GL11.glVertex2f(x+size, y-size);
        GL11.glVertex2f(x+size, y+size);
        GL11.glVertex2f(x-size, y+size);

        GL11.glEnd();
        GL11.glPopMatrix();
    }

    private void setRotation() {
        rotation += rotationSpeed * delta;
    }

    private float calculateRColor(){
        if (x>0){
            return (float)x/(GameStarter.WINDOW_WIDTH);
        } else {
            return 0f;
        }
    }

    private float calculateGColor(){
        if (y>0){
            return (float)y/(GameStarter.WINDOW_HEIGHT);
        } else {
            return 0f;
        }
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

    public void rotateLeft() {
        rotationSpeed = -0.15f;
        rotation -= 0.35f * delta;
    }

    public void rotateRight() {
        rotationSpeed = +0.15f;
        rotation  += 0.35f * delta;
    }

    private void keepOnScreen(){
        if (x < 0) x=GameStarter.WINDOW_WIDTH;
        if (x > GameStarter.WINDOW_WIDTH) x = 0;
        if (y < 0) y=GameStarter.WINDOW_HEIGHT;
        if (y > GameStarter.WINDOW_HEIGHT) y = 0;
        if (rotation<0f) rotation = 360f+rotation;
        if (rotation>360f) rotation = rotation - 360f;
    }

    public void setItemInMiddle() {
        x= GameStarter.WINDOW_WIDTH/2 - size/2;
        y= GameStarter.WINDOW_HEIGHT/2 - size/2;
    }
}
