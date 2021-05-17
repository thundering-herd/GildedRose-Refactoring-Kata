package com.gildedrose

class AgedBrie(item: Item) : AbstractItemV2(item) {
    override fun updateQualityInternal() {
        if (item.sellIn > 0) {
            increaseQualityBy(1)
        } else {
            increaseQualityBy(2)
        }
    }
}
