package com.gildedrose.rules;

import com.gildedrose.Item;

/**
 * @author uitzetter
 */
public class IncreaseQualityRule implements InventoryRule {
    @Override
    public boolean appliesTo(Item item) {
        return item.name.equals("Aged Brie");
    }

    @Override
    public void apply(Item item) {
        if (item.sellIn > 0) {
            item.quality++;
        } else {
            item.quality += 2;
        }
    }
}
