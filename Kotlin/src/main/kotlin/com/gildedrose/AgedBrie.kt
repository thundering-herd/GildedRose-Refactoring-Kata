package com.gildedrose

class AgedBrie(item: Item) : AbstractItemV2(item) {
    override fun updateQualityInternal() {
        if (item.sellIn > 0) {
            increaseQualityByOne()
        } else {
            increaseQualityByTwo()
        }
        ensureQualityNoMoreThanFifty()
    }
}
