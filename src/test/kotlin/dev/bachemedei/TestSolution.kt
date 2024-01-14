package dev.bachemedei

import TestData
import kotlin.test.Test
import kotlin.test.assertEquals

class TestSolution {
    @Test
    fun testSolution() {
        TestData.data.forEachIndexed { index, data ->
            println("Test ${index + 1} input: ${data.inputValue}")
            val expected = data.outputValue
            val actual = solution2(data.inputValue)
            assertEquals(expected, actual)
            println("Test ${index + 1} passed with output $actual")
        }
    }
}