package org.domnikl.data_structures

class LinkedList<T> {
    var size: Int = 0
        private set

    private var head: Node<T>? = null

    fun addFirst(element: T) {
        val newNode = Node(element)

        if (head == null) {
            head = newNode
        } else {
            newNode.next = head
            head = newNode
        }

        size++
    }

    fun addLast(element: T) {
        val newNode = Node(element)
        val lastNode = lastNode()

        lastNode.next = newNode
        size++
    }

    fun toList(): List<T> {
        val l = mutableListOf<T>()
        var current = head

        do {
            current?.data?.let { l.add(it) }
            current = current?.next
        } while (current != null)

        return l.toList()
    }

    fun first(): T {
        if (head == null) {
            throw IllegalStateException("empty list")
        }

        return head!!.data
    }

    fun last(): T {
        if (head == null) {
            throw IllegalStateException("empty list")
        }

        return lastNode().data
    }

    private fun lastNode(): Node<T> {
        var current = head!!

        while (current.next != null) {
            current = current.next!!
        }

        return current
    }

    fun deleteFirst() {
        head = head?.next
        size--
    }

    fun clear() {
        head = null
        size = 0
    }

    fun delete(element: T) {
        if (head == null) {
            throw IllegalStateException("empty list")
        }

        if (head?.data == element) {
            head = head?.next
            size--
        }

        var current = head

        do {
            if (current?.next?.data == element) {
                current?.next = current?.next?.next
                size--
            }

            current = current?.next
        } while (current != null)
    }

    override fun toString(): String {
        return toList().joinToString(", ")
    }

    private class Node<N>(val data: N) {
        var next: Node<N>? = null
    }
}
