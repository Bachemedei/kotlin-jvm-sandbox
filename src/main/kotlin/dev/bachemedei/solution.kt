package dev.bachemedei

import java.util.Stack

fun isValid1(s: String): Boolean {
    var expected = ""
    s.forEachIndexed { index, brace ->
        expected = if (brace.isClosingBrace()) {
            when {
                expected.isEmpty() -> return false
                expected.first() != brace -> return false
                else -> expected.substring(1)
            }
        } else {
            brace.getMatchingBrace() + expected
        }
    }
    return expected.isEmpty()
}

fun isValid2(s: String): Boolean {
    val expected = Stack<Char>()
    s.forEach { brace ->
        when {
            brace.isClosingBrace() && expected.isEmpty() -> return false
            brace.isClosingBrace() && expected.pop() != brace -> return false
            !brace.isClosingBrace() -> expected.push(brace.getMatchingBrace())
        }
    }
    return expected.isEmpty()
}

fun Char.getMatchingBrace() = when (this) {
    '(' -> ')'
    '[' -> ']'
    '{' -> '}'
    ')' -> '('
    ']' -> '['
    '}' -> '{'
    else -> throw IllegalArgumentException("Input is not a brace")
}

fun Char.isClosingBrace() = this == ')' || this == ']' || this == '}'
