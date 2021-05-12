package com.gildedrose

abstract class AbstractItemV2(protected val item: Item) {
    fun updateQuality() {
        if (qualityMayChange()) updateQualityInternal()
        updateSellInInternal()
    }

    protected open fun qualityMayChange(): Boolean {
        return item.quality > 0 || item.quality < 50
    }

    protected open fun updateSellInInternal() {
        item.sellIn -= 1
    }

    protected open fun updateQualityInternal() {
        if (item.quality > 0) {
            decreaseQuality(item)
        }
    }

    private fun decreaseQuality(item: Item) {
        if (item.sellIn > 0) {
            decreaseQualityUntilSellByDate(item)
        } else {
            decreaseQualityAfterSellByDate(item)
        }
    }

    private fun decreaseQualityUntilSellByDate(item: Item) {
        item.quality -= 1
    }

    private fun decreaseQualityAfterSellByDate(item: Item) {
        item.quality -= 2
        if (item.quality < 0) item.quality = 0
    }
}
