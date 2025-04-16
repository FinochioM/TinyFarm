package efemat.tinyfarm;

import com.badlogic.gdx.graphics.Texture;

public class WateringCan extends Item{
    public WateringCan(Texture texture) {
        super("watering_can", "Watering Can", "Used to water crops and plants.", texture);
    }

    @Override
    public void use(Player player) {
        System.out.println("Using watering can at position: " + player.getPosition());
    }
}
