package com.gildedrose

const val BRIE = "Aged Brie"
const val CONCERT = "Backstage passes to a TAFKAL80ETC concert"
const val SULFUR = "Sulfuras, Hand of Ragnaros"
const val REGULAR = "Regular"


class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (item in items) {
            if (item.name != BRIE && item.name != CONCERT) {
                if (item.quality > 0) {
                    if (item.name != SULFUR) {
                        item.quality = item.quality - 1
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality = item.quality + 1

                    if (item.name == CONCERT) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality = item.quality + 1
                            }
                        }
                    }
                }
            }

            if (item.name != SULFUR) {
                item.sellIn = item.sellIn - 1
            }

            if (item.sellIn < 0) {
                if (item.name != BRIE) {
                    if (item.name != CONCERT) {
                        if (item.quality > 0) {
                            if (item.name != SULFUR) {
                                item.quality = item.quality - 1
                            }
                        }
                    } else {
                        item.quality = item.quality - item.quality
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality = item.quality + 1
                    }
                }
            }
        }
    }

}

