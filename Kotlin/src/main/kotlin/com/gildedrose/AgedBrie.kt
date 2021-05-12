package com.gildedrose

class AgedBrie(item: Item) : AbstractItemV2(item) {
    override fun updateQualityInternal() {
        if (item.sellIn > 0) {
            item.quality += 1
        } else {
            item.quality += 2
        }
        if (item.quality > 50) item.quality = 50
    }
}
