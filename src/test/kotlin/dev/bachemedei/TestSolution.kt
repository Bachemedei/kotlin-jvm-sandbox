package dev.bachemedei

import TestData
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestSolution {
    @Test
    fun testSolution() {
        TestData.data.forEachIndexed { index, data ->
            println("Test ${index + 1}, input ${data.inputValue}")
            val expected = data.outputValue
            val result = isValid(data.inputValue)
            assertEquals(expected, result, "Test ${index + 1} failed, expected $expected, got $result")
        }
    }
}