package com.gildedrose.rules;

import com.gildedrose.Item;

/**
 * @author uitzetter
 */
public class IncreaseQualityRule implements InventoryRule {
    @Override
    public boolean appliesTo(Item item) {
        return item.name.equals("Aged Brie");// || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public void apply(Item item) {
        item.quality++;
    }
}
