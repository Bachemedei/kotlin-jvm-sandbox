package dev.bachemedei

fun solution() {
    // TODO
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
