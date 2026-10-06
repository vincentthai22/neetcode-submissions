class Solution {
    fun getSum(a: Int, b: Int): Int {
    var incrementor = 0
    var isDecrementing = false
    if(a < 0) {
        isDecrementing = true
    }
    for(i in 0 until abs(a)) {
        if(!isDecrementing) {
            incrementor++
        } else {
            incrementor--
        }

    }
    isDecrementing = false

    if(b < 0) {
        isDecrementing = true
    }

    for(i in 0 until abs(b)) {
        if(!isDecrementing) {
            incrementor++
        } else {
            incrementor--
        }
    }
    return incrementor
}
}
