package com.gildedrose

const val BRIE = "Aged Brie"
const val CONCERT = "Backstage passes to a TAFKAL80ETC concert"
const val SULFUR = "Sulfuras, Hand of Ragnaros"
const val REGULAR = "Regular"


class GildedRose(var items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {
            if (items[i].name != BRIE && items[i].name != CONCERT) {
                if (items[i].quality > 0) {
                    if (items[i].name != SULFUR) {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1

                    if (items[i].name == CONCERT) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }

                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (items[i].name != SULFUR) {
                items[i].sellIn = items[i].sellIn - 1
            }

            if (items[i].sellIn < 0) {
                if (items[i].name != BRIE) {
                    if (items[i].name != CONCERT) {
                        if (items[i].quality > 0) {
                            if (items[i].name != SULFUR) {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

}

