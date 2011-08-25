package com.barabatz.firstrts.texture;

import com.barabatz.firstrts.GameStarter;
import org.lwjgl.opengl.GL11;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: bobaffe
 * Date: 26.08.11
 * Time: 00:42
 */
public class TextureHandler {


    public TextureHandler() {
        GL11.glMatrixMode(GL11.GL_PROJECTION);
        GL11.glLoadIdentity();
        GL11.glOrtho(0, GameStarter.WINDOW_WIDTH,GameStarter.WINDOW_HEIGHT,0,1,-1);
        GL11.glMatrixMode(GL11.GL_MODELVIEW);
    }

    public void draw(List<SquareEntity> squareEntities) {
        for (SquareEntity squareEntity : squareEntities){
            squareEntity.draw();
        }
    }

    
}
