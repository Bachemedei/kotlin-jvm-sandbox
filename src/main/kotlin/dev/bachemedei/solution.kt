package dev.bachemedei

fun solution() {
    // TODO
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

}
