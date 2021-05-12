package com.gildedrose

import com.gildedrose.ItemV2Factory.createItemV2

class GildedRoseV2(var items: Array<Item>) {

    fun updateQuality() {
        items.forEach {
            createItemV2(it).updateQuality()
        }
    }
}
