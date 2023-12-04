package com.gildedrose;

import com.gildedrose.rules.DecreaseQualityDoubleRule;
import com.gildedrose.rules.DecreaseQualityRule;
import com.gildedrose.rules.EnforceQualityBoundariesRule;
import com.gildedrose.rules.IncreaseQualityDeadlineRule;
import com.gildedrose.rules.IncreaseQualityRule;
import com.gildedrose.rules.InventoryRule;
import com.gildedrose.rules.UpdateSellInRule;

import java.util.List;

class GildedRose {
    Item[] items;

    /**
     * The rules are applied in the order they are defined in this list.
     */
    private final List<InventoryRule> rules = List.of(
        new DecreaseQualityRule(),
        new DecreaseQualityDoubleRule(),
        new IncreaseQualityRule(),
        new IncreaseQualityDeadlineRule(),
        new UpdateSellInRule(),
        new EnforceQualityBoundariesRule()
    );

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            rules.stream()
                .filter(rule -> rule.appliesTo(item))
                .forEach(rule -> rule.apply(item));
        }
    }
}
