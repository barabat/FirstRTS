package com.barabatz.firstrts.texture;

import com.barabatz.firstrts.GameStarter;
import org.lwjgl.opengl.GL11;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * Date: 26.08.11
 * Time: 00:42
 */
public class EntityHandler {


    public EntityHandler() {

    }

    public void draw(int delta, List<SquareEntity> squareEntities) {
        for (SquareEntity squareEntity : squareEntities){
            squareEntity.draw(delta);
        }
    }

    
}
