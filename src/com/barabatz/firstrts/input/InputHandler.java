package com.barabatz.firstrts.input;

import com.barabatz.firstrts.texture.TextureHandler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

/**
 * Created by IntelliJ IDEA.
 * User: bobaffe
 * Date: 26.08.11
 * Time: 00:18
 */
public class InputHandler {

    TextureHandler textureHandler;

    public InputHandler(TextureHandler textureHandler) {
        this.textureHandler = textureHandler;
    }

    public void pollInput() {

        //LEFT MOUSE button
        if (Mouse.isButtonDown(0)){
            int x = Mouse.getX();
            int y = Mouse.getY();
            System.out.println("LEFT MOUSE DOWN @ X:" + x + " Y: " +y);
        }
        //RIGHT MOUSE button
        if (Mouse.isButtonDown(1)){
            int x = Mouse.getX();
            int y = Mouse.getY();
            System.out.println("RIGHT MOUSE DOWN @ X:" + x + " Y: " + y);
        }

        //MIDDLE MOUSE button
        if (Mouse.isButtonDown(2)){
            int x = Mouse.getX();
            int y = Mouse.getY();
            System.out.println("MIDDLE MOUSE DOWN @ X:" + x + " Y: " + y);
        }


        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            if (textureHandler!= null) {
                textureHandler.setItemInMiddle();
            }
            System.out.println("SPACE KEY IS DOWN");
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            if (textureHandler!= null) {
                textureHandler.moveRight();
            }
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            if (textureHandler!= null) {
                textureHandler.moveLeft();
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            if (textureHandler!= null) {
                textureHandler.moveUp();
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            if (textureHandler!= null) {
                textureHandler.moveDown();
            }
        }

        while (Keyboard.next()) {
            if(Keyboard.getEventKeyState()) {
                switch (Keyboard.getEventKey()){
                    case Keyboard.KEY_W:
                        System.out.println("W Key Pressed");
                        break;
                    case Keyboard.KEY_A:
                        System.out.println("A Key Pressed");
                        break;
                    case Keyboard.KEY_S:
                        System.out.println("S Key Pressed");
                        break;
                    case Keyboard.KEY_D:
                        System.out.println("D Key Pressed");
                        break;
                    default:
                        System.out.println("Other key pressed: " + Keyboard.getKeyName(Keyboard.getEventKey()));
                        break;
                }
            } else {
                switch (Keyboard.getEventKey()){
                    case Keyboard.KEY_W:
                        System.out.println("W Key Released");
                        break;
                    case Keyboard.KEY_A:
                        System.out.println("A Key Released");
                        break;
                    case Keyboard.KEY_S:
                        System.out.println("S Key Released");
                        break;
                    case Keyboard.KEY_D:
                        System.out.println("D Key Released");
                        break;
                    default:
                        System.out.println("Other key released: " + Keyboard.getKeyName(Keyboard.getEventKey()));
                        break;
                }
            }
        }
    }
}
