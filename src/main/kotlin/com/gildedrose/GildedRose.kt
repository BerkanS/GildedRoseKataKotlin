package com.gildedrose

import com.gildedrose.model.Item

class GildedRose(var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) {
            item.updateItem()
        }
    }
}

