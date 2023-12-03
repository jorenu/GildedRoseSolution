package com.gildedrose;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            switch (item.name) {
                case "Sulfuras, Hand of Ragnaros" -> {}
                case "Aged Brie" -> updateAgedBrie(item);
                case "Backstage passes to a TAFKAL80ETC concert" -> updateBackstagePasses(item);
                default -> updateGenericItem(item);
            }
        }
    }

    private void updateGenericItem(Item item) {
        if (item.sellIn > 0) {
            item.quality--;
        } else {
            item.quality -= 2;
        }
        fixQuality(item);
        item.sellIn--;
    }

    private void updateAgedBrie(Item item) {
        item.quality++;
        fixQuality(item);
        item.sellIn--;
    }

    private void updateBackstagePasses(Item item) {
        if (item.sellIn > 10) {
            item.quality++;
        } else if (item.sellIn > 5) {
            item.quality += 2;
        } else if (item.sellIn > 0) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }
        fixQuality(item);
        item.sellIn--;
    }

    private void fixQuality(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        } else if (item.quality > 50) {
            item.quality = 50;
        }
    }

}
