package com.gildedrose;

class GildedRose {
    public static final int QUALITY_MAX = 50;
    public static final int QUALITY_MIN = 0;
    public static final String SULFURAS_HAND_OF_RAGNAROS = "Sulfuras, Hand of Ragnaros";
    public static final String AGED_BRIE = "Aged Brie";
    public static final String BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT = "Backstage passes to a TAFKAL80ETC concert";
    public static final String CONJURED_ITEM = "Conjured Cake";
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            //update item quality
            updateItemQuality(item);

            //update item SellIn
            updateItemSellIn(item);
        }
    }

    /**
     * Update item sellIn by category name
     * @param item
     */
    private void updateItemSellIn(Item item) {
        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
            item.sellIn = item.sellIn - 1;
        }
        if (item.sellIn < 0) {
            if (!item.name.equals(AGED_BRIE)) {
                if (!item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                    if (item.quality > QUALITY_MIN) {
                        if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS)) {
                            item.quality = item.quality - 1;
                        }
                    }
                } else {
                    item.quality = item.quality - item.quality;
                }
            } else {
                if (item.quality < QUALITY_MAX) {
                    item.quality = item.quality + 1;
                }
            }

        }
    }

    /**
     * Update item quality by category name.
     * @param item Object Item
     */
    private void updateItemQuality(Item item) {
        if (!item.name.equals(AGED_BRIE) && !item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
            if (item.quality > QUALITY_MIN) {
                if (!item.name.equals(SULFURAS_HAND_OF_RAGNAROS) && item.name.equals(CONJURED_ITEM)) {
                    item.quality = item.quality - 2;

                } else {
                    item.quality = item.quality - 1;

                }

            }
        } else {
            if (item.quality < QUALITY_MAX) {
                item.quality = item.quality + 1;

                if (item.name.equals(BACKSTAGE_PASSES_TO_A_TAFKAL_80_ETC_CONCERT)) {
                    if (item.sellIn < 11) {
                        if (item.quality < QUALITY_MAX) {
                            item.quality = item.quality + 1;
                        }
                    }

                    if (item.sellIn < 6) {
                        if (item.quality < QUALITY_MAX) {
                            item.quality = item.quality + 1;
                        }
                    }
                }
            }
        }
    }
}
