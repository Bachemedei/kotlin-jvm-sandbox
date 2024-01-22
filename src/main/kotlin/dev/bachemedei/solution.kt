package dev.bachemedei

fun mergeTwoLists1(list1: ListNode?, list2: ListNode?): ListNode? {
    return when {
        list1 == null -> list2
        list2 == null -> list1
        else -> {
            var l1: ListNode? = list1
            var l2: ListNode? = list2
            var head: ListNode? = null
            var current: ListNode? = null
            while (l1 != null || l2 != null) {
                if (head == null && current != null) head = current
                when {
                    l1.value <= l2.value -> {
                        val nextNode = ListNode(l1.value)
                        current?.next = nextNode
                        current = nextNode
                        l1 = l1?.next
                    }
                    l2.value < l1.value -> {
                        val nextNode = ListNode(l2.value)
                        current?.next = nextNode
                        current = nextNode
                        l2 = l2?.next
                    }
                }
            }
            head
        }
    }
}

fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? = when {
    list1 == null -> list2
    list2 == null -> list1
    list1.`val` < list2.`val` -> {
        list1.next = mergeTwoLists2(list1.next, list2)
        list1
    }
    else -> {
        list2.next = mergeTwoLists2(list2.next, list1)
        list2
    }
}

data class ListNode(var `val`: Int, var next: ListNode? = null)
val ListNode?.value: Int
    get() = this?.`val` ?: Int.MAX_VALUE
fun ListNode?.toList(): List<Int> {
    return if (this == null) emptyList()
    else {
        var current = this
        val list = mutableListOf<Int>()
        while (current != null) {
            list.add(current.value)
            current = current.next
        }
        list
    }
}

fun List<Int>.toNode(): ListNode? {
    return if (this.isEmpty()) null
    else {
        var head: ListNode? = null
        var current: ListNode? = null
        this.forEach { int ->
            if (head == null) {
                head = ListNode(int)
                current = head
            } else {
                val next = ListNode(int)
                current?.next = next
                current = next
            }
        }
        head
    }
}
