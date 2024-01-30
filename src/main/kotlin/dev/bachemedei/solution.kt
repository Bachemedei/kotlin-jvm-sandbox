package dev.bachemedei

fun invertTree(root: TreeNode?): TreeNode? {
    return root.invert()
}

fun TreeNode?.invert(): TreeNode? {
    if (this == null) return null
    val node = TreeNode(`val`)
    node.left = right.also { it.invert() }
    node.right = left.also { it.invert() }
    return node
}

data class TreeNode(var `val`: Int) {
    val value = `val`
    var left: TreeNode? = null
    var right: TreeNode? = null
}
