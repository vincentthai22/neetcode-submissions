class Solution {
    val EMPTY = '.'
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        // track all vertical values per x-index
        val verticalSet = hashMapOf<Int, MutableSet<Char>>()

        // track all horizontal values per y-index
        val horSet = hashMapOf<Int, MutableSet<Char>>()

        // track each 9-square
        val squareMap = hashMapOf<Int, MutableSet<Char>>()

        board.forEachIndexed() { y, row ->
            row.forEachIndexed() { x, char ->
                verticalSet.getOrPut(x){ hashSetOf() }.let {
                    if(it.contains(char)) return false
                    if(char != EMPTY) it.add(char)
                }

                horSet.getOrPut(y){ hashSetOf() }.let {
                    if(it.contains(char)) return false
                    if(char != EMPTY) it.add(char)
                }

                squareMap.get9x9(x, y)?.let {
                    if(it.contains(char)) return false
                    if(char != EMPTY) it.add(char)
                }
                
            }
        }
        return true
    }

    fun HashMap<Int, MutableSet<Char>>.get9x9(x: Int, y: Int): MutableSet<Char>? {
        return when {
            (x < 3 && y < 3) -> this.getOrPut(0) { hashSetOf() }
            (x in 3..5 && y < 4) -> this.getOrPut(1) { hashSetOf() }
            (x in 6..8 && y < 4) -> this.getOrPut(2) { hashSetOf() }

            (x < 3 && y in 3..5) -> this.getOrPut(3) { hashSetOf() }
            (x in 3..5 && y in 3..5) -> this.getOrPut(4) { hashSetOf() }
            (x in 6..8 && y in 3..5) -> this.getOrPut(5) { hashSetOf() }

            (x < 3 && y in 6..8) -> this.getOrPut(6) { hashSetOf() }
            (x in 3..5 && y in 6..8) -> this.getOrPut(7) { hashSetOf() }
            (x in 6..8 && y in 6..8) -> this.getOrPut(8) { hashSetOf() }
            else -> null
        }
    }
}
