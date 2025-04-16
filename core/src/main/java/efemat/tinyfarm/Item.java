package efemat.tinyfarm;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public abstract class Item {
    protected String id;
    protected String name;
    protected String description;
    protected Texture texture;

    public Item(String id, String name, String description, Texture texture){
        this.id = id;
        this.name = name;
        this.description = description;
        this.texture = texture;
    }

    public abstract void use(Player player);

    public void render(SpriteBatch batch, float x, float y, float size) {
        batch.draw(texture, x, y, size, size);
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public Texture getTexture() { return texture; }
}
