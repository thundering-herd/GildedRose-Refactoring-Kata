package com.gildedrose

abstract class AbstractItemV2(protected val item: Item) {
    fun updateQuality() {
        if (qualityMayChange()) updateQualityInternal()
        updateSellInInternal()
    }

    abstract fun updateQualityInternal()

    protected open fun qualityMayChange(): Boolean {
        return item.quality in 1..49
    }

    protected open fun updateSellInInternal() {
        item.sellIn -= 1
    }

    protected fun decreaseQualityBy(value: Int) {
        item.quality -= value
    }

    protected fun increaseQualityBy(value: Int) {
        item.quality += value
    }


    protected fun setQualityToZero() {
        item.quality = 0
    }

    protected fun ensureQualityNoLessThanZero() {
        if (item.quality < 0) item.quality = 0
    }

    protected fun ensureQualityNoMoreThanFifty() {
        if (item.quality > 50) item.quality = 50
    }
}
