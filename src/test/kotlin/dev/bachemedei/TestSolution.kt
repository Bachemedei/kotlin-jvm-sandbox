package dev.bachemedei

import TestData
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class TestSolution {
    @Test
    fun testSolution() {
        TestData.data.forEachIndexed { index, data ->
            val test = "Test ${index + 1}"
            val input = data.inputValue
            val expectedOutput = data.outputValue
            println("$test input $input")
            val actualOutput = maxProfit(input)
            assertEquals(expectedOutput, actualOutput, "$test failed, expected $expectedOutput, got $actualOutput")
        }
    }
}