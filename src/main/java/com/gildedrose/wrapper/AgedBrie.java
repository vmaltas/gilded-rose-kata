package com.gildedrose.wrapper;

import com.gildedrose.Item;

import static com.gildedrose.constants.GildedRoseConfiguration.MAX_QUALITY;

public class AgedBrie extends CommonItem {
    public AgedBrie(Item item) {
        super(item);
    }

    @Override
    public void updateQualityBeforeExpire() {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }

    @Override
    public void updateQualityAfterExpire() {
        if (item.quality < MAX_QUALITY) {
            item.quality++;
        }
    }
}
