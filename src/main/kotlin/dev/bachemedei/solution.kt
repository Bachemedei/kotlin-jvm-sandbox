package dev.bachemedei

import kotlin.math.sign

fun solution1(x: Int): Int {
    if (x in 0..9) return x
    val string = if (x.sign < 0) x.unaryMinus().toString() else x.toString()
    val reversed = try {
        string.reversed().toInt()
    } catch (ex: NumberFormatException) {
        0
    }
    return if (x.sign < 0) reversed.unaryMinus() else reversed
}

fun solution2(x: Int): Int {
    if (x in 0..9) return x
    var current = x
    var reversed = 0
    while (current != 0) {
        val remainder = current % 10
        reversed = remainder + (reversed.timesTenOrNull() ?: return 0)
        current /= 10
    }
    return if (x.sign != reversed.sign) 0 else reversed
}

fun Int.timesTenOrNull(): Int? {
    if (this == 0) return 0
    var next = 0
    for (i in 1..10) {
        next += this
        if (next.sign != this.sign) return null
    }
    return next
}
