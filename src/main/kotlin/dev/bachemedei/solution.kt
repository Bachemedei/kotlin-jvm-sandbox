package dev.bachemedei

fun isValid(s: String): Boolean {
    var expected = ""
    s.forEachIndexed { index, brace ->
        expected = if (brace.isClosingBrace()) {
            when {
                expected.isEmpty() -> return false
                s.length < index + expected.length -> return false
                expected.first() != brace -> return false
                else -> expected.substring(1)
            }
        } else {
            brace.getMatchingBrace() + expected
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
