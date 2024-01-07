fun longestPalindrome(s: String): String {
    var longest = 0..0
    fun check(p1: Int, p2: Int) {
        var leftPointer = p1
        var rightPointer = p2
        while (leftPointer >= 0 && rightPointer < s.length && s[leftPointer] == s[rightPointer]) {
            val currentRange = leftPointer..rightPointer
            if (currentRange.count() > longest.count()) longest = currentRange

            leftPointer--
            rightPointer++
        }
    }
    s.indices.forEach { index ->
        if (index > 0) check(index - 1, index) // handles even windows
        check(index, index) // handles odd windows
    }
    return s.substring(longest)
}
