package com.barabatz.firstrts.texture;

import com.barabatz.firstrts.GameStarter;
import org.lwjgl.opengl.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.util.ResourceLoader;

import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Date: 26.08.11
 * Time: 01:42
 */
public class SquareEntity {
    private int x = 100;
    private int y = 100;
    private int entitySize = 50;
    private float rotation = 0f;
    private int delta;
    private String entityName;
    private float rotationSpeed = 0f;
    private int entitySpeed = 1;
    private int newX = 0;
    private int newY = 0;
    boolean targetReached = true;


    public void draw(int delta){
        this.delta = delta;
        Texture tankTexture = getTankTexture();
        entityName = tankTexture.toString();
        moveEntity();
        keepOnScreen();
        // Clear the screen and the depth buffer

        float B = 0f;
        //Set quad color (R,G,B)
        //GL11.glColor3f(calculateRColor(), calculateGColor(), B);

        //Draw a quad
        GL11.glPushMatrix();
        GL11.glTranslatef(x, y, 0);
        GL11.glRotatef(rotation, 0f, 0f, 1f);
        GL11.glTranslatef(-x, -y, 0);

        GL11.glBegin(GL11.GL_QUADS);

            GL11.glTexCoord2f(0,0);
			GL11.glVertex2f(x-entitySize,y-entitySize);
			GL11.glTexCoord2f(1,0);
			GL11.glVertex2f(x+entitySize,y-entitySize);
			GL11.glTexCoord2f(1,1);
			GL11.glVertex2f(x+entitySize,y+entitySize);
			GL11.glTexCoord2f(0,1);
			GL11.glVertex2f(x-entitySize,y+entitySize);
//        GL11.glVertex2f(x-entitySize,y-entitySize);
//        GL11.glVertex2f(x+entitySize, y-entitySize);
//        GL11.glVertex2f(x+entitySize, y+entitySize);
//        GL11.glVertex2f(x-entitySize, y+entitySize);

        GL11.glEnd();
        GL11.glPopMatrix();
    }

    private Texture getTankTexture() {
        try{
            return TextureLoader.getTexture("PNG", ResourceLoader.getResourceAsStream("res/simple_tank.png"));
        } catch (IOException iox) {
            iox.printStackTrace();
        }
        return null;
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

    public void moveTo(int newX, int newY) {
        System.out.println("Moving " + entityName + " to " +x+ "," +y);
        this.newX = newX;
        this.newY = newY;
        targetReached = false;
    }

    private void moveEntity(){
        if (!targetReached){
            if(x<newX) x++;
            if(x>newX) x--;
            if(y<newY) y++;
            if(y>newY) y--;
            if(x==newX && y==newY){
                targetReached=true;
            }
        }
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
        x= GameStarter.WINDOW_WIDTH/2 - entitySize /2;
        y= GameStarter.WINDOW_HEIGHT/2 - entitySize /2;
        rotation = 0f;
    }
}
