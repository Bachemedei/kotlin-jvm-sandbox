package dev.bachemedei

import TestData
import kotlin.test.Test
import kotlin.test.assertEquals

class TestSolution {
    @Test
    fun testSolution() {
        TestData.data.forEachIndexed { index, data ->
            val expected = data.outputValue
            val actual = initialSolution(data.inputValue.nums1, data.inputValue.nums2)
            assertEquals(expected, actual, "Test ${index + 1} failed, expected: $expected, actual $actual")
            println("Test ${index + 1} passed")
        }
    }
}