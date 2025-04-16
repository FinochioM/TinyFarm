package efemat.tinyfarm;

import com.badlogic.gdx.graphics.Texture;
import java.util.HashMap;
import java.util.Map;

public class ItemDatabase {
    private static ItemDatabase instance;
    private Map<String, Item> items;

    private ItemDatabase() {
        items = new HashMap<>();
        loadItems();
    }

    public static ItemDatabase getInstance() {
        if (instance == null) {
            instance = new ItemDatabase();
        }
        return instance;
    }

    private void loadItems() {
        Texture wateringCanTexture = new Texture("watering_can.png");

        items.put("watering_can", new WateringCan(wateringCanTexture));
    }

    public Item getItem(String id) {
        return items.get(id);
    }

    public void dispose() {
        for (Item item : items.values()) {
            item.getTexture().dispose();
        }
    }
}
