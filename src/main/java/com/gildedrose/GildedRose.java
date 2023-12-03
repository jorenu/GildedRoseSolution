package com.gildedrose;

class GildedRose {

    private static final int GENERIC_DECREASE_RATE = 1;
    private static final int CONJURED_DECREASE_RATE = GENERIC_DECREASE_RATE * 2;

    private static final int BACKSTAGE_PASS_MAX_QUALITY_INCREASE = 3;
    private static final int BACKSTAGE_PASS_MEDIUM_QUALITY_INCREASE = 2;
    private static final int BACKSTAGE_PASS_MIN_QUALITY_INCREASE = 1;

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
                case "Conjured Mana Cake" -> updateConjured(item);
                default -> updateGenericItem(item);
            }
        }
    }

    private void updateGenericItem(Item item) {
        decreaseQuality(item, GENERIC_DECREASE_RATE);
        enforceQualityBoundaries(item);
        advanceDay(item);
    }

    private void updateAgedBrie(Item item) {
        increaseQuality(item);
        enforceQualityBoundaries(item);
        advanceDay(item);
    }

    private void updateBackstagePasses(Item item) {
        if (item.sellIn > 10) {
            increaseQuality(item, BACKSTAGE_PASS_MIN_QUALITY_INCREASE);
        } else if (item.sellIn > 5) {
            increaseQuality(item, BACKSTAGE_PASS_MEDIUM_QUALITY_INCREASE);
        } else if (item.sellIn > 0) {
            increaseQuality(item, BACKSTAGE_PASS_MAX_QUALITY_INCREASE);
        } else {
            item.quality = 0;
        }
        enforceQualityBoundaries(item);
        advanceDay(item);
    }

    private void updateConjured(Item item) {
        decreaseQuality(item, CONJURED_DECREASE_RATE);
        enforceQualityBoundaries(item);
        advanceDay(item);
    }

    private void enforceQualityBoundaries(Item item) {
        if (item.quality < 0) {
            item.quality = 0;
        } else if (item.quality > 50) {
            item.quality = 50;
        }
    }

    private void advanceDay(Item item) {
        item.sellIn--;
    }

    private void decreaseQuality(Item item, int baseAmount) {
        if (item.sellIn > 0) {
            item.quality -= baseAmount;
        } else {
            item.quality -= baseAmount * 2;
        }
    }

    private void increaseQuality(Item item) {
        increaseQuality(item, 1);
    }

    private void increaseQuality(Item item, int amount) {
        item.quality += amount;
    }

}
