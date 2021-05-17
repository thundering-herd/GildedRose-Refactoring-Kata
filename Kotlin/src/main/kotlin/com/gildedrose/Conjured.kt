package com.gildedrose

class Conjured(item: Item) : AbstractItemV2(item) {
    override fun updateQualityInternal() {
        if (item.sellIn > 0) {
            decreaseQualityBy(2)
        } else {
            decreaseQualityBy(4)
        }
    }
}
