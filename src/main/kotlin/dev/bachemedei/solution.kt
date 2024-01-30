package dev.bachemedei

import kotlin.math.max
import kotlin.math.min

fun maxProfit(prices: IntArray): Int {
    var minPrice = prices.first()
    var highestDiff = 0
    prices.forEach { currentPrice ->
        highestDiff = max(highestDiff, currentPrice - minPrice)
        minPrice = min(minPrice, currentPrice)
    }
    return highestDiff
}
