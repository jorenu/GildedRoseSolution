package com.gildedrose.rules;

import com.gildedrose.Item;

/**
 * @author uitzetter
 */
public class EnforceQualityBoundariesRule implements InventoryRule {
    @Override
    public boolean appliesTo(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    @Override
    public void apply(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        } else if (item.quality > 50) {
            item.quality = 50;
        }
    }
}
