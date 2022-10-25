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
                    updateRegularAndConjured(item)
                }

                else -> {
                    updateRegularAndConjured(item)
                }
            }
        }
    }

    private fun updateBrie(item: Item) {
        if (item.quality < 50) {
            item.quality++
        }

        item.sellIn = item.sellIn - 1

        if (item.sellIn < 0 && item.quality < 50) {
            item.quality++
        }
    }

    private fun updateConcert(item: Item) {
        if (item.quality < 50) {
            item.quality++

            if (item.sellIn < 11 && item.quality < 50) {
                item.quality++
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.quality++
            }
        }

        item.sellIn = item.sellIn - 1

        if (item.sellIn < 0) {
            item.quality = 0
        }
    }

    private fun updateRegularAndConjured(item: Item) {
        if (item.quality > 0) {
            item.quality--
        }

        if (item.name == CONJURED && item.quality > 0) {
            item.quality--
        }

        item.sellIn--

        if (item.sellIn < 0 && item.quality > 0) {
            item.quality--
        }
    }

}

