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

    protected fun decreaseQualityByOne() {
        item.quality -= 1
    }

    protected fun decreaseQualityByTwo() {
        item.quality -= 2
    }

    protected fun decreaseQualityByFour() {
        item.quality -= 4
    }

    protected fun increaseQualityByOne() {
        item.quality += 1
    }

    protected fun increaseQualityByTwo() {
        item.quality += 2
    }

    protected fun increaseQualityByThree() {
        item.quality += 3
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
