package com.gildedrose.model

class Concert(
    sellIn: Int,
    quality: Int
) : Item(sellIn, quality) {

    override fun updateItem() {
        if (quality < 50) {
            quality++

            if (sellIn < 11 && quality < 50) {
                quality++
            }

            if (sellIn < 6 && quality < 50) {
                quality++
            }
        }

        sellIn -= 1

        if (sellIn < 0) {
            quality = 0
        }
    }
}