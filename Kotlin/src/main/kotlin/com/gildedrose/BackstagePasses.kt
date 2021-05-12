package com.gildedrose

class BackstagePasses(item: Item) : AbstractItemV2(item) {
    override fun updateQualityInternal() {
        when {
            item.sellIn > 10 -> increaseQualityByOne()
            item.sellIn > 5 -> increaseQualityByTwo()
            item.sellIn > 0 -> increaseQualityByThree()
            else -> setQualityToZero()
        }
    }
}
