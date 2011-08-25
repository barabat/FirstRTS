package com.barabatz.firstrts;

import com.barabatz.firstrts.input.InputHandler;
import com.barabatz.firstrts.texture.TextureHandler;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * Created by IntelliJ IDEA.
 * User: bobaffe
 * Date: 25.08.11
 * Time: 22:02
 */
public class GameStarter {
    public static int WINDOW_WIDTH = 1024;
    public static int WINDOW_HEIGHT = 512;

    private InputHandler inputHandler;
    private TextureHandler textureHandler;


    public GameStarter(){

    }

    private void start() {
        try{
            Display.setDisplayMode(new DisplayMode(WINDOW_WIDTH,WINDOW_HEIGHT));
            Display.create();
            textureHandler = new TextureHandler();
            inputHandler = new InputHandler(textureHandler);
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        while (!Display.isCloseRequested()) {
            inputHandler.pollInput();
            textureHandler.draw();
            Display.update();
        }

        Display.destroy();
    }

    public static void main(String[] args) {
        GameStarter gameStarter = new GameStarter();
        gameStarter.start();
    }

}
