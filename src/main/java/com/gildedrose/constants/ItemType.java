package com.gildedrose.constants;

public enum ItemType {

    AGED_BRIE("Aged Brie"),
    SULFURAS("Sulfuras, Hand of Ragnaros"),
    BACKSTAGE_PASSES("Backstage passes"),
    CONJURED("Conjured");
    private final String startsWith;

    ItemType(String startsWith) {
        this.startsWith = startsWith;
    }

    public String getStartsWith() {
        return startsWith;
    }
}
