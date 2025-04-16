package efemat.tinyfarm;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class TinyFarm extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture playerTexture;
    private Player player;

    @Override
    public void create() {
        batch = new SpriteBatch();
        playerTexture = new Texture("player.png");

        float playerX = Gdx.graphics.getWidth() / 2f - (playerTexture.getWidth() / 2f);
        float playerY = Gdx.graphics.getHeight() / 2f - (playerTexture.getHeight() / 2f);
        player = new Player(playerTexture, playerX, playerY, 2.0f);
    }

    @Override
    public void render() {
        float deltaTime = Gdx.graphics.getDeltaTime();

        player.update(deltaTime);

        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        batch.begin();

        player.render(batch);

        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        playerTexture.dispose();
    }
}
