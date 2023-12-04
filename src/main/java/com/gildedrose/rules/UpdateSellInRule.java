package com.gildedrose.rules;

import com.gildedrose.Item;

/**
 * @author uitzetter
 */
public class UpdateSellInRule implements InventoryRule {
    @Override
    public boolean appliesTo(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    @Override
    public void apply(Item item) {
        item.sellIn--;
    }
}
