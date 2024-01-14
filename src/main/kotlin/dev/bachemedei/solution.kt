package dev.bachemedei

import kotlin.math.max
import kotlin.math.min

// This solution is 0(nums1.size + nums2.size)
fun initialSolution(nums1: IntArray, nums2: IntArray): Double {
    val merged = (nums1 + nums2).sorted()
    val index = merged.size / 2
    return if (merged.size % 2 == 1) {
        merged[index].toDouble()
    } else {
        (merged[index].toDouble() + merged[index - 1].toDouble()) / 2
    }
}

// This solution is 0(log (nums1.size + nums2.size))
fun finalSolution(a: IntArray, b: IntArray, start: Int = 0, end: Int = a.size): Double {
    if (a.size > b.size) return finalSolution(b, a)
    /**
     * Partition each array so number of elements in left partition of A is equal to number of elements in right partition of B
     * e.g. a = [1, 3, 8, 9, 15], b = [7, 11, 18, 19, 21, 25]
     * Partitions of A = [1, 3], [8, 9, 15] partitions of B = [7, 11, 18, 19], [21, 25]
     * leftA = [1, 3], rightB = [21, 25] -> Both contain 2 elements
     */
    val positionA = (start + end) / 2
    val leftA = a.getOrElse(positionA - 1) { Int.MIN_VALUE }
    val rightA = a.getOrElse(positionA) { Int.MAX_VALUE }

    val positionB = (a.size + b.size + 1) / 2 - positionA
    val leftB = b.getOrElse(positionB - 1) { Int.MIN_VALUE }
    val rightB = b.getOrElse(positionB) { Int.MAX_VALUE }
    /**
     * Correct partitions are where all elements in A left less than or equal to B right && B left less than or equal to A right
     * Arrays are ordered - only need to compare last element of left partitions & first element of right partitions
     * When total elements in both arrays is even, median is avg of largest element on left and smallest element on right
     * When total elements in both arrays is odd, median is the largest element on left
     *  e.g. leftA = [1, 3, 8, 9], rightA = [15] leftB = [7, 11], rightB = [18, 19, 21, 25]
     *  leftA.last (9) < rightB.first (18) = true & leftB.last (11) < rightA.first (15)
     *  total elements = 11, max of leftA.last (9) and leftB.last (11) = 11
     */
    return when {
        leftA <= rightB && leftB <= rightA -> {
            // Correct partition found, return avg of middle 2 elements if total size is odd, else middle element
            if ((a.size + b.size) % 2 == 0) (max(leftA, leftB) + min(rightA, rightB)) / 2.0
            else max(leftA, leftB) * 1.0
        }
        leftA > rightB -> {
            // leftA is greater than rightB -> move search towards left side of A
            finalSolution(a, b, start, positionA - 1)
        }
        else -> {
            // leftB is greater than rightA -> move search towards right side of A
            finalSolution(a, b, positionA + 1, end)
        }
    }
}
