package com.barabatz.firstrts;

import com.barabatz.firstrts.input.InputHandler;
import com.barabatz.firstrts.texture.EntityHandler;
import com.barabatz.firstrts.texture.SquareEntity;
import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

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
    private EntityHandler entityHandler;
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
//        initTextures();
        getDelta(); //call once before loop to initialize lastFrame
        lastFPS = getTime(); //call before loop to initialize fps timer
        while (!Display.isCloseRequested()) {
            int delta = getDelta();
//            renderTexture();
            update(delta);
            Display.update();
            Display.sync(100);
        }

        Display.destroy();
        System.exit(0);
    }


    private void update(int delta){
        inputHandler.pollInput();
        entityHandler.draw(delta, squareEntities);
        updateFPS();
    }

    private void setupDisplay() {
        try{
            Display.setDisplayMode(new DisplayMode(WINDOW_WIDTH, WINDOW_HEIGHT));
            Display.create();
            Display.setVSyncEnabled(true);

            GL11.glEnable(GL11.GL_TEXTURE_2D);
            GL11.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);

            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
            GL11.glViewport(0,0,WINDOW_WIDTH,WINDOW_HEIGHT);

            GL11.glMatrixMode(GL11.GL_PROJECTION);
            GL11.glLoadIdentity();
            GL11.glOrtho(0, WINDOW_WIDTH,WINDOW_HEIGHT,0,1,-1);
            GL11.glMatrixMode(GL11.GL_MODELVIEW);

            initHandlers();
        } catch (LWJGLException e) {
            e.printStackTrace();
            System.exit(0);
        }
    }

    private void initHandlers() {
        entityHandler = new EntityHandler();
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
