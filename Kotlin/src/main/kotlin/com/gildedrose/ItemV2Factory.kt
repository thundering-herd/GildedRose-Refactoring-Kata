package com.gildedrose

object ItemV2Factory {

    fun createItemV2(item: Item): AbstractItemV2 {
        return when {
            item.name.startsWith("Backstage passes") -> BackstagePasses(item)
            item.name.startsWith("Sulfuras") -> Sulfuras(item)
            item.name.startsWith("Aged Brie") -> AgedBrie(item)
            else -> RegularShopItem(item)
        }
    }
}
