package com.barabatz.firstrts;

import com.barabatz.firstrts.input.InputHandler;
import com.barabatz.firstrts.texture.SquareEntity;
import com.barabatz.firstrts.texture.TextureHandler;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
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
    
    /** time at last frame */
    long lastFrame;

    /** frames per second */
    int fps;
    /** last fps time */
    long lastFPS;



    public GameStarter(){

    }

    private void start() {
        setupDisplay();
        getDelta(); //call once before loop to initialize lastFrame
        lastFPS = getTime(); //call before loop to initialize fps timer
        while (!Display.isCloseRequested()) {
            int delta = getDelta();
            update(delta);
            Display.update();
        }

        Display.destroy();
    }

    private void update(int delta){
        inputHandler.pollInput();
        textureHandler.draw(delta, squareEntities);
        updateFPS();
    }

    private void setupDisplay() {
        try{
            Display.setDisplayMode(new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT));
            Display.create();
            initHandlers();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void initHandlers() {
        textureHandler = new TextureHandler();
        SquareEntity squareEntity = new SquareEntity();
        squareEntities = new ArrayList<SquareEntity>();
        squareEntities.add(squareEntity);
        inputHandler = new InputHandler(squareEntities);
    }

    /** 
	 * Calculate how many milliseconds have passed
	 * since last frame.
	 *
	 * @return milliseconds passed since last frame
	 */
	public int getDelta() {
	    long time = getTime();
	    int delta = (int) (time - lastFrame);
	    lastFrame = time;

	    return delta;
	}

    /**
	 * Get the accurate system time
	 *
	 * @return The system time in milliseconds
	 */
	public long getTime() {
	    return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}

    public static void main(String[] args) {
        GameStarter gameStarter = new GameStarter();
        gameStarter.start();
    }
    
    /**
     * Calculate the FPS and set it in the title bar
     */
    public void updateFPS() {
        if (getTime() - lastFPS > 1000) {
            Display.setTitle("FPS: " + fps);
            fps = 0;
            lastFPS += 1000;
        }
        fps++;
    }

}
