package dev.bachemedei

import TestData
import kotlin.test.Test
import kotlin.test.assertEquals

class TestSolution {
    @Test
    fun testSolution() {
        TestData.data.forEachIndexed { index, data ->
            println("Test ${index + 1}, input ${data.inputValue}")
            val expected = data.outputValue
            val result = isValid2(data.inputValue)
            assertEquals(expected, result, "Test ${index + 1} failed, expected $expected, got $result")
        }
    }
}