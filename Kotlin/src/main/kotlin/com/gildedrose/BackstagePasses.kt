package com.gildedrose

class BackstagePasses(item: Item) : AbstractItemV2(item) {
    override fun updateQualityInternal() {
        when {
            item.sellIn  > 10 -> item.quality += 1
            item.sellIn > 5 -> item.quality += 2
            item.sellIn > 0 -> item.quality += 3
            else -> item.quality = 0
        }
    }

}
