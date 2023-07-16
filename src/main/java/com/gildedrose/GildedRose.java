package com.gildedrose;

import com.gildedrose.wrapper.*;

import static com.gildedrose.constants.GildedRoseConfiguration.EXPIRE_DAY;
import static com.gildedrose.constants.ItemType.*;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            CommonItem commonItem = chooseItemType(item);

            commonItem.updateQualityBeforeExpire();
            commonItem.updateSellin();
            if (item.sellIn < EXPIRE_DAY) {
                commonItem.updateQualityAfterExpire();
            }
        }
    }

    private CommonItem chooseItemType(Item item) {
        if (item.name.startsWith(AGED_BRIE.getStartsWith())) {
            return new AgedBrie(item);
        } else if (item.name.startsWith(SULFURAS.getStartsWith())) {
            return new Sulfuras(item);
        } else if (item.name.startsWith(BACKSTAGE_PASSES.getStartsWith())) {
            return new Ticket(item);
        } else if (item.name.startsWith(CONJURED.getStartsWith())) {
            return new Conjured(item);
        } else {
            return new CommonItem(item);
        }
    }
}