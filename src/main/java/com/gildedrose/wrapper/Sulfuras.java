package com.gildedrose.wrapper;

import com.gildedrose.Item;

public class Sulfuras extends CommonItem {
    public Sulfuras(Item item) {
        super(item);
    }

    @Override
    public void updateSellin() {
        // Quality is not effected since it is a rule
    }

    @Override
    public void updateQualityBeforeExpire() {
        // Sellin is not effected since it is a rule
    }

    @Override
    public void updateQualityAfterExpire() {
        // Quality is not effected since it is a rule
    }
}
