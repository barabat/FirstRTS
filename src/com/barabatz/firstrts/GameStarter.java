package com.barabatz.firstrts;

import com.barabatz.firstrts.input.InputHandler;
import com.barabatz.firstrts.texture.SquareEntity;
import com.barabatz.firstrts.texture.TextureHandler;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Date: 25.08.11
 * Time: 22:02
 */
public class GameStarter {
    public static int WINDOW_WIDTH = 1024;
    public static int WINDOW_HEIGHT = 512;

    private InputHandler inputHandler;
    private TextureHandler textureHandler;
    List<SquareEntity> squareEntities;


    public GameStarter(){

    }

    private void start() {
        try{
            Display.setDisplayMode(new DisplayMode(WINDOW_WIDTH,WINDOW_HEIGHT));
            Display.create();
            textureHandler = new TextureHandler();
            SquareEntity squareEntity = new SquareEntity();
            squareEntities = new ArrayList<SquareEntity>();
            squareEntities.add(squareEntity);
            inputHandler = new InputHandler(squareEntities);
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }

        while (!Display.isCloseRequested()) {
            inputHandler.pollInput();
            textureHandler.draw(squareEntities);
            Display.update();
        }

        Display.destroy();
    }

    public static void main(String[] args) {
        GameStarter gameStarter = new GameStarter();
        gameStarter.start();
    }

}
