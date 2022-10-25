package com.gildedrose

import com.gildedrose.model.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class GildedRoseTest {

    @Test
    fun `test sulfur is unaffected`() {
        val items = arrayOf<Item>(Sulfur(0, 80))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(80, app.items[0].quality)
        assertEquals(0, app.items[0].sellIn)
    }

    @Test
    fun `test regular item decreases sellin and quality by one`() {
        val items = arrayOf<Item>(Regular( 20, 30))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(19, app.items[0].sellIn)
        assertEquals(29, app.items[0].quality)
    }

    @Test
    fun `test quality goes up for Aged Brie and Concert`() {
        val items = arrayOf(AgedBrie(10, 20), Concert( 12, 20))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(21, app.items[0].quality)
        assertEquals(21, app.items[1].quality)
    }

    @Test
    fun `test Concert quality goes up by two if 10 days or less left`() {
        val items = arrayOf<Item>(Concert(10, 20))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(22, items[0].quality)
    }

    @Test
    fun `test concert quality goes up by three if 5 days or less left`() {
        val items = arrayOf<Item>(Concert(5, 20))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(23, items[0].quality)
    }

    @Test
    fun `test quality decreases by 2 if sellIn has passed`() {
        val items = arrayOf<Item>(Regular(0, 20))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(18, items[0].quality)
        assertEquals(-1, items[0].sellIn)
    }

    @Test
    fun `test Concert quality to zero if sellIn has passed`() {
        val items = arrayOf<Item>(Concert(0, 20))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(0, items[0].quality)
        assertEquals(-1, items[0].sellIn)
    }

    @Test
    fun `test quality does not go higher than 50, except Sulfuras`() {
        val items = arrayOf(
            AgedBrie(4, 50),
            Concert(4, 50),
            Conjured(4, 50),
            Regular(4, 50)
        )
        val app = GildedRose(items)
        app.updateQuality()

        for (item in items) {
            assertEquals(false, item.quality > 50)
        }
    }

    @Test
    fun `test conjured items quality decreases by 2`() {
        val items = arrayOf<Item>(Conjured(15, 15))
        val app = GildedRose(items)
        app.updateQuality()

        assertEquals(14, items[0].sellIn)
        assertEquals(13, items[0].quality)
    }

    @Test
    fun `test quality is never less than 0`() {
        val items = arrayOf(
            Regular(4, 0),
            AgedBrie(4, 0),
            Concert(4, 0),
            Sulfur(4, 0),
            Conjured(4, 1)
        )

        val app = GildedRose(items)
        app.updateQuality()

        for (item in items) {
            assertEquals(false, item.quality < 0)
        }
    }

}


