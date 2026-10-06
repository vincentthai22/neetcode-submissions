class MinStack() {

    val stack = mutableListOf<Int>()
    val priorityQueue = PriorityQueue<Int>()

    fun push(value: Int) {
        priorityQueue.offer(value)
        stack.add(value)
    }

    fun pop() {
        stack.removeLastOrNull()?.let {
            priorityQueue.remove(it)
        }
    }

    // basically peek
    fun top(): Int = stack.last()

    fun getMin(): Int = priorityQueue.peek()
}
