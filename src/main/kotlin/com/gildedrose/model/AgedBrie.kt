package com.gildedrose.model

class AgedBrie(
    sellIn: Int,
    quality: Int
) : Item(sellIn, quality) {

    override fun updateItem() {
        if (quality < 50) {
            quality++
        }

        sellIn -= 1

        if (sellIn < 0 && quality < 50) {
            quality++
        }
    }
}