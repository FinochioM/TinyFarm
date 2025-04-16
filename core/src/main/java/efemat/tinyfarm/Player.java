package efemat.tinyfarm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Player extends Entity {
    private static final float MOVEMENT_SPEED = 200.0f;

    public Player(Texture texture, float x, float y, float scale) {
        super(texture, x, y, scale);
    }

    @Override
    public void update(float deltaTime) {
        float moveX = 0;
        float moveY = 0;

        // Vertical movement
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            moveY += MOVEMENT_SPEED * deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            moveY -= MOVEMENT_SPEED * deltaTime;
        }

        // Horizontal movement
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            moveX -= MOVEMENT_SPEED * deltaTime;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            moveX += MOVEMENT_SPEED * deltaTime;
        }

        position.x += moveX;
        position.y += moveY;

        position.x = Math.max(0, Math.min(position.x, Gdx.graphics.getWidth() - getWidth()));
        position.y = Math.max(0, Math.min(position.y, Gdx.graphics.getHeight() - getHeight()));
    }
}
