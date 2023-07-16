package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class CommonItem {

    protected Item item;

    public CommonItem(Item item) {
        this.item = item;
    }

    public void updateSellin() {
        item.sellIn--;
    }

    public void updateQualityBeforeExpire() {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    public void updateQualityAfterExpire() {
        if (item.quality > 0) {
            item.quality--;
        }
    }
}
