package com.gildedrose

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource

internal class GildedRoseV2V2Test {

    @ParameterizedTest(name = "{0} item with sellIn {1} and quality {2}")
    @CsvFileSource(files = ["src/test/resources/updateQualityTestData.csv"], numLinesToSkip = 1)
    fun testUpdateQuality(name: String, sellIn: Int, quality: Int, expectedSellIn: Int, expectedQuality: Int) {
        val items = arrayOf(Item(name, sellIn, quality))
        val app = GildedRoseV2(items)
        app.updateQuality()
        assertEquals(expectedSellIn, app.items[0].sellIn, "sellIn")
        assertEquals(expectedQuality, app.items[0].quality, "quality")
    }

}
