package com.gildedrose.wrapper;

import com.gildedrose.Item;

import static com.gildedrose.constants.GildedRoseConfiguration.MIN_QUALITY;

public class Conjured extends CommonItem {

    public Conjured(Item item) {
        super(item);
    }

    @Override
    public void updateQualityBeforeExpire() {
        item.quality = Math.max((item.quality - 2), MIN_QUALITY);
    }

    @Override
    public void updateQualityAfterExpire() {
        item.quality = Math.max((item.quality - 2), MIN_QUALITY);
    }
}
