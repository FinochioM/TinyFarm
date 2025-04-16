package efemat.tinyfarm;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Inventory {
    private static final int HOTBAR_SIZE = 8;
    private Item[] hotbarItems;
    private int selectedSlot = 0;
    private Texture slotTexture;
    private Texture selectedSlotTexture;

    public Inventory() {
        hotbarItems = new Item[HOTBAR_SIZE];
        slotTexture = new Texture("inventory_slot.png");
        selectedSlotTexture = new Texture("inventory_slot_selected.png");

        hotbarItems[0] = ItemDatabase.getInstance().getItem("watering_can");
    }

    public void update(Player player) {
        for (int i = 0; i < HOTBAR_SIZE; i++) {
            if (Gdx.input.isKeyJustPressed(Input.Keys.NUM_1 + i)) {
                selectedSlot = i;
                break;
            }
        }

        if (Gdx.input.isKeyJustPressed(Input.Keys.E)) {
            useSelectedItem(player);
        }
    }

    public void render(SpriteBatch batch) {
        float slotSize = 40;
        float padding = 4;
        float hotbarWidth = (slotSize + padding) * HOTBAR_SIZE - padding;
        float startX = (Gdx.graphics.getWidth() - hotbarWidth) / 2;
        float startY = 20;

        for (int i = 0; i < HOTBAR_SIZE; i++) {
            float x = startX + (slotSize + padding) * i;
            float y = startY;

            Texture slotTex = (i == selectedSlot) ? selectedSlotTexture : slotTexture;
            batch.draw(slotTex, x, y, slotSize, slotSize);

            if (hotbarItems[i] != null) {
                hotbarItems[i].render(batch, x + 4, y + 4, slotSize - 8);
            }
        }
    }

    private void useSelectedItem(Player player) {
        if (hotbarItems[selectedSlot] != null) {
            hotbarItems[selectedSlot].use(player);
        }
    }

    public void dispose() {
        slotTexture.dispose();
        selectedSlotTexture.dispose();
    }

    public boolean addItem(Item item) {
        for (int i = 0; i < HOTBAR_SIZE; i++) {
            if (hotbarItems[i] == null) {
                hotbarItems[i] = item;
                return true;
            }
        }

        return false;
    }

    public Item getSelectedItem() {
        return hotbarItems[selectedSlot];
    }
}
