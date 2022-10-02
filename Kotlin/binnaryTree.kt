class Node(
    var key: Int,
    var left: Node? = null,
    var right: Node? = null)

fun find(value: Int): Node? = when {
    this.value > value -> left?.findByValue(value)
    this.value < value -> right?.findByValue(value)
    else -> this
}
fun find(value: Int): Node? = when {
    this.value > value -> left?.findByValue(value)
    this.value < value -> right?.findByValue(value)
    else -> this
}
fun delete(value: Int) {
    when {
        value > key -> scan(value, this.right, this)
        value < key -> scan(value, this.left, this)
        else -> removeNode(this, null)
    }
}

private fun removeNoChildNode(node: Node, parent: Node?) {
    if (parent == null) {
        throw IllegalStateException("Can not remove the root node without child nodes")
    }
    if (node == parent.left) {
        parent.left = null
    } else if (node == parent.right) {
        parent.right = null
    }
}


