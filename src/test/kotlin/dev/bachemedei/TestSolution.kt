package dev.bachemedei

import TestData
import kotlin.test.Test
import kotlin.test.assertEquals

class TestSolution {
    @Test
    fun testSolution() {
        TestData.data.forEachIndexed { index, it ->
            val list1 = it.inputValue1.toNode()
            val list2 = it.inputValue2.toNode()
            println("Test ${index + 1}, input: ${it.inputValue1}, ${it.inputValue2}, expected: ${it.outputValue}")
            val expected = it.outputValue
            val actual = mergeTwoLists2(list1, list2)
            assertEquals(expected, actual.toList())
        }
    }
}