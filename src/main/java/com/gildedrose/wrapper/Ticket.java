package com.gildedrose.wrapper;

import com.gildedrose.Item;

import static com.gildedrose.constants.GildedRoseConfiguration.MAX_QUALITY;

public class Ticket extends CommonItem {
    public Ticket(Item item) {
        super(item);
    }

    @Override
    public void updateQualityBeforeExpire() {
        item.quality++;
        if (item.sellIn < 11) {
            item.quality = Math.min(item.quality + 1, MAX_QUALITY);
        }
        if (item.sellIn < 6) {
            item.quality = Math.min(item.quality + 1, MAX_QUALITY);
        }
    }

    @Override
    public void updateQualityAfterExpire() {
        item.quality = 0;
    }
}
