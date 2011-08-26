package com.barabatz.firstrts.input;

import com.barabatz.firstrts.texture.SquareEntity;
import com.barabatz.firstrts.texture.TextureHandler;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Date: 26.08.11
 * Time: 00:18
 */
public class InputHandler {

    List<SquareEntity> squareEntities;

    public InputHandler(List<SquareEntity> squareEntities) {
        this.squareEntities = squareEntities;
    }

    private void moveItem(SquareEntity squareEntity){

        if (Keyboard.isKeyDown(Keyboard.KEY_SPACE)){
            if (squareEntity!= null){
                squareEntity.setItemInMiddle();
            }
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
            if (squareEntity!= null) {
                squareEntity.moveRight();
            }
        }

        if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
            if (squareEntity!= null) {
                squareEntity.moveLeft();
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
            if (squareEntity!= null) {
                squareEntity.moveUp();
            }
        }
        if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
            if (squareEntity!= null) {
                squareEntity.moveDown();
            }
        }
    }

    public void pollInput() {
        for (SquareEntity squareEntity : squareEntities) {
            moveItem(squareEntity);
        }
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
