package com.gildedrose

class Conjured(item: Item) : AbstractItemV2(item) {
    override fun updateQualityInternal() {
        if (item.sellIn > 0) {
            decreaseQualityByTwo()
        } else {
            decreaseQualityByFour()
            ensureQualityNoLessThanZero()
        }
    }
}
