package com.gildedrose

class BackstagePasses(item: Item) : AbstractItemV2(item) {
    override fun updateQualityInternal() {
        when {
            item.sellIn > 10 -> increaseQualityBy(1)
            item.sellIn > 5 -> increaseQualityBy(2)
            item.sellIn > 0 -> increaseQualityBy(3)
            else -> setQualityToZero()
        }
    }
}
