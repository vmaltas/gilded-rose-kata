package com.gildedrose;

import org.junit.jupiter.api.Test;

import static com.gildedrose.constants.GildedRoseConfiguration.MAX_QUALITY;
import static com.gildedrose.constants.GildedRoseConfiguration.MIN_QUALITY;
import static org.junit.jupiter.api.Assertions.assertEquals;

class GildedRoseTest {
    @Test
    void test_common_item_1_day_passed() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
    }

    @Test
    void test_aged_brie_item_1_day_passed() {
        Item[] items = new Item[] { new Item("Aged Brie", 2, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
        assertEquals(1, app.items[0].quality);
    }

    @Test
    void test_legendary_item_1_day_passed_doesnt_change() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", 0, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void test_ticket_item_still_has_days_over_15_1_day_passed() {
        Item[] items = new Item[] { new Item("Backstage passes to Metallica concert", 15, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(14, app.items[0].sellIn);
        assertEquals(21, app.items[0].quality);
    }

    @Test
    void test_ticket_item_below_5_left_1_day_passed() {
        Item[] items = new Item[] { new Item("Backstage passes to Metallica concert", 5, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(43, app.items[0].quality);
    }

    @Test
    void test_ticket_item_below_10_left_1_day_passed() {
        Item[] items = new Item[] { new Item("Backstage passes to Metallica concert", 10, 40) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(42, app.items[0].quality);
    }

    @Test
    void test_conjured_item_1_day_passed() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 10, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void test_aged_brie_after_expire_1_day_passed() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(22, app.items[0].quality);
    }

    @Test
    void test_common_item_after_expire_1_day_passed() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(18, app.items[0].quality);
    }

    @Test
    void test_aged_brie_almost_max_quality_after_expire_1_day_passed() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 49) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(MAX_QUALITY, app.items[0].quality);
    }

    @Test
    void test_legendary_item_after_expire_1_day_passed() {
        Item[] items = new Item[] { new Item("Sulfuras, Hand of Ragnaros", -1, 80) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(80, app.items[0].quality);
    }

    @Test
    void test_ticket_item_after_expire_1_day_passed() {
        Item[] items = new Item[] { new Item("Backstage passes to Metallica concert", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(MIN_QUALITY, app.items[0].quality);
    }

    @Test
    void test_conjured_item_after_expire_1_day_passed() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 20) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(16, app.items[0].quality);
    }

    @Test
    void test_common_item_quality_already_0_before_expire_1_day_passed() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 5, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void test_common_item_quality_already_0_after_expire_1_day_passed() {
        Item[] items = new Item[] { new Item("+5 Dexterity Vest", 0, 0) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(0, app.items[0].quality);
    }

    @Test
    void test_aged_brie_quality_already_max_quality_before_expire_1_day_passed() {
        Item[] items = new Item[] { new Item("Aged Brie", 5, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_aged_brie_quality_already_max_quality_after_expire_1_day_passed() {
        Item[] items = new Item[] { new Item("Aged Brie", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(50, app.items[0].quality);
    }

    @Test
    void test_conjured_item_quality_already_max_quality_after_expire_1_day_passed() {
        Item[] items = new Item[] { new Item("Conjured Mana Cake", 0, 50) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(-1, app.items[0].sellIn);
        assertEquals(46, app.items[0].quality);
    }


    @Test
    void combined_test_after_1_day_passed(){
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(9, app.items[0].sellIn);
        assertEquals(19, app.items[0].quality);
        assertEquals(1, app.items[1].sellIn);
        assertEquals(1, app.items[1].quality);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(80, app.items[2].quality);
        assertEquals(14, app.items[3].sellIn);
        assertEquals(21, app.items[3].quality);
        assertEquals(9, app.items[4].sellIn);
        assertEquals(50, app.items[4].quality);
        assertEquals(4, app.items[5].sellIn);
        assertEquals(50, app.items[5].quality);
        assertEquals(2, app.items[6].sellIn);
        assertEquals(4, app.items[6].quality);
    }

    @Test
    void combined_test_after_10_days_passed(){
        Item[] items = new Item[] {
                new Item("+5 Dexterity Vest", 10, 20), //
                new Item("Aged Brie", 2, 0), //
                new Item("Sulfuras, Hand of Ragnaros", 0, 80), //
                new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
                new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
                new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
                // this conjured item does not work properly yet
                new Item("Conjured Mana Cake", 3, 6) };
        GildedRose app = new GildedRose(items);
        for(int i =0;i<10;i++){
            app.updateQuality();
        }
        assertEquals(0, app.items[0].sellIn);
        assertEquals(10, app.items[0].quality);
        assertEquals(-8, app.items[1].sellIn);
        assertEquals(18, app.items[1].quality);
        assertEquals(0, app.items[2].sellIn);
        assertEquals(80, app.items[2].quality);
        assertEquals(5, app.items[3].sellIn);
        assertEquals(35, app.items[3].quality);
        assertEquals(0, app.items[4].sellIn);
        assertEquals(50, app.items[4].quality);
        assertEquals(-5, app.items[5].sellIn);
        assertEquals(0, app.items[5].quality);
        assertEquals(-7, app.items[6].sellIn);
        assertEquals(0, app.items[6].quality);
    }

}
