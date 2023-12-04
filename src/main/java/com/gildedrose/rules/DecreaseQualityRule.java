package com.gildedrose.rules;

import com.gildedrose.Item;

/**
 * @author uitzetter
 */
public class DecreaseQualityRule implements InventoryRule {
    @Override
    public boolean appliesTo(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros")
            && !item.name.equals("Aged Brie")
            && !item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public void apply(Item item) {
        if (item.sellIn <= 0) {
            item.quality -= 2;
        } else {
            item.quality--;
        }
    }
}
