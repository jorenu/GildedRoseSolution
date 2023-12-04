package com.gildedrose.rules;

import com.gildedrose.Item;

/**
 * @author uitzetter
 */
public class DecreaseQualityDoubleRule extends DecreaseQualityRule {

    @Override
    public boolean appliesTo(Item item) {
        return item.name.startsWith("Conjured");
    }
}
