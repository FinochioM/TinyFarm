package efemat.tinyfarm;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public abstract class Entity {
    protected Vector2 position;
    protected Texture texture;
    protected float scale;

    public Entity(Texture texture, float x, float y, float scale) {
        this.texture = texture;
        this.position = new Vector2(x, y);
        this.scale = scale;
    }

    public void render(SpriteBatch batch) {
        float width = texture.getWidth() * scale;
        float height = texture.getHeight() * scale;

        batch.draw(texture, position.x, position.y, width, height);
    }

    public abstract void update(float deltaTime);

    public Vector2 getPosition(){
        return position;
    }

    public void setPosition(float x, float y) {
        position.x = x;
        position.y = y;
    }

    public float getWidth() {
        return texture.getWidth() * scale;
    }

    public float getHeight() {
        return texture.getHeight() * scale;
    }
}
