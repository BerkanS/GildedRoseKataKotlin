package com.gildedrose

const val BRIE = "Aged Brie"
const val CONCERT = "Backstage passes to a TAFKAL80ETC concert"
const val SULFUR = "Sulfuras, Hand of Ragnaros"
const val REGULAR = "Regular"
const val CONJURED = "Conjured"

class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            when (item.name) {
                BRIE -> {
                    updateBrie(item)
                }

                SULFUR -> {
                    // Do nothing
                }

                CONCERT -> {
                    updateConcert(item)
                }

                CONJURED -> {
                    updateConjured(item)
                }

                else -> {
                    updateRegular(item)
                }
            }
        }
    }

    private fun updateBrie(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }

        item.sellIn = item.sellIn - 1

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality = item.quality + 1
        }
    }

    private fun updateConcert(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality++
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality++
                }
            }
        }

        item.sellIn = item.sellIn - 1

        if (item.sellIn < 0) {
            item.quality = 0
        }
    }

    private fun updateRegular(item: Item) {
        if (item.quality > 0) {
            item.quality--
        }

        item.sellIn--

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--
        }
    }

    private fun updateConjured(item: Item) {
        if (item.quality > 0) {
            item.quality = item.quality - 2
        }

        item.sellIn--

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--
        }
    }
}

