class KthLargest {

    val numsList: MutableList<Int>
    val k: Int
    constructor(k: Int, nums: IntArray) {
        numsList = nums.toMutableList()
        this.k = k
    }

    fun add(num: Int): Int {
        numsList.add(num)
        numsList.sort()
        return numsList[numsList.size - k]
    }
}
