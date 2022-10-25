package com.gildedrose.model

class Conjured(
    sellIn: Int,
    quality: Int
) : Item(sellIn, quality) {

    override fun updateItem() {
        if (quality > 0) {
            quality--
        }

        if (quality > 0) {
            quality--
        }

        sellIn--

        if (sellIn < 0 && quality > 0) {
            quality--
        }
    }
}