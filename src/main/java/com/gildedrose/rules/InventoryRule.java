package com.gildedrose.rules;

import com.gildedrose.Item;

/**
 * @author uitzetter
 */
public interface InventoryRule {
    boolean appliesTo(Item item);
    void apply(Item item);
}
