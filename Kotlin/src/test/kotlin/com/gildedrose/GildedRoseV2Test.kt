package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseV2V2Test {

    @Test
    fun regularItemDegradeToZero() {
        val items = arrayOf(Item("regular", 1, 1))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun regularItemZeroQuality() {
        val items = arrayOf(Item("regular", 1, 0))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun regularItemZeroSellInZeroQuality() {
        val items = arrayOf(Item("regular", 0, 0))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun regularItemDoubleDegradeAfterSellByDate() {
        val items = arrayOf(Item("regular", -1, 2))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(-2, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun agedBrieIncreaseInQuality() {
        val items = arrayOf(Item("Aged Brie", 1, 1))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
        assertEquals(2, app.items[0].quality)
    }

    @Test
    fun agedBrieDoubleInQuality() {
        val items = arrayOf(Item("Aged Brie", 0, 1))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(3, app.items[0].quality)
    }

    @Test
    fun agedBrieNeverPassesInQualityOver50At50() {
        val items = arrayOf(Item("Aged Brie", 0, 50))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun agedBrieNeverPassesInQualityOver50At49() {
        val items = arrayOf(Item("Aged Brie", 0, 49))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun sulfurasNeverChanges() {
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 1, 80))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(1, app.items[0].sellIn)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun backstageIncreaseInQualitySellInGreate10() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 11, 1))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(10, app.items[0].sellIn)
        assertEquals(2, app.items[0].quality)
    }

    @Test
    fun backstageIncreasesBy2QualitySellIn10() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 10, 1))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(9, app.items[0].sellIn)
        assertEquals(3, app.items[0].quality)
    }

    @Test
    fun backstageIncreasesBy2QualitySellIn6() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 6, 1))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(5, app.items[0].sellIn)
        assertEquals(3, app.items[0].quality)
    }

    @Test
    fun backstageIncreasesBy2QualitySellIn5() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 5, 1))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(4, app.items[0].sellIn)
        assertEquals(4, app.items[0].quality)
    }

    @Test
    fun backstageWorthlessQualitySellIn0() {
        val items = arrayOf(Item("Backstage passes to a TAFKAL80ETC concert", 0, 1))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun conjuredUntilSellByDate() {
        val items = arrayOf(Item("Conjured X", 1, 10))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun conjuredAfterSellByDate() {
        val items = arrayOf(Item("Conjured X", 0, 10))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(6, app.items[0].quality)
    }
}
