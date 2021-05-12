package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun regularItemDegradeToZero() {
        val items = arrayOf(Item("regular", 1, 1))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun regularItemZeroQuality() {
        val items = arrayOf(Item("regular", 1, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(0, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun regularItemZeroSellInZeroQuality() {
        val items = arrayOf(Item("regular", 0, 0))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-1, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun regularItemDoubleDegradeAfterSellByDate() {
        val items = arrayOf(Item("regular", -1, 2))
        val app = GildedRose(items)
        app.updateQuality()
        assertEquals(-2, app.items[0].sellIn)
        assertEquals(0, app.items[0].quality)
    }
}
