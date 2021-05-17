package com.gildedrose

class RegularShopItem(item: Item) : AbstractItemV2(item) {
    override fun updateQualityInternal() {
        if (item.sellIn > 0) {
            decreaseQualityBy(1)
        } else {
            decreaseQualityBy(2)
        }
    }
}
