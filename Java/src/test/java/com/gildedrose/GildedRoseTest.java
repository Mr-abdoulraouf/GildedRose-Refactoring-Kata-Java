package com.gildedrose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {

    @Test
    void foo() {
        Item[] items = new Item[] { new Item("foo", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void conjured_item_decrease_twiceInQuality() {
        Item[] items = new Item[] { new Item("Conjured Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("Conjured Cake", app.items[0].name);
        assertEquals(2, app.items[0].sellIn);
        assertEquals(4,app.items[0].quality);
    }


}
