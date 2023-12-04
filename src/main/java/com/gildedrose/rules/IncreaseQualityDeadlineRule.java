package com.gildedrose.rules;

import com.gildedrose.Item;

/**
 * @author uitzetter
 */
public class IncreaseQualityDeadlineRule implements InventoryRule {
    @Override
    public boolean appliesTo(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public void apply(Item item) {
        if (item.sellIn <= 0) {
            item.quality = 0;
        } else if (item.sellIn <= 5) {
            item.quality += 3;
        } else if (item.sellIn <= 10) {
            item.quality += 2;
        } else {
            item.quality++;
        }
    }
}
