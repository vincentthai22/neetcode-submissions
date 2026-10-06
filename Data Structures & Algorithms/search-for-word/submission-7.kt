class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        // find starting point and then explore all neighbors
        for (i in 0 until board.size) {
            for (j in 0 until board[0].size) {
                if (board[i][j] == word[0]) {
                    val visited =
                        Array(board.size, { BooleanArray(board[0].size, { false }) })
                    if(
                        searchRecursive(
                            board,
                            visited,
                            i,
                            j,
                            word
                        )
                    ) {
                        return true
                    }
                    
                }
            }
        }
        return false
    }

    fun searchRecursive(
        board: Array<CharArray>,
        visited: Array<BooleanArray>,
        i: Int,
        j: Int,
        word: String
    ): Boolean {

        if(i !in board.indices || j !in board[0].indices) {
            return false
        }
        

        

        if(visited[i][j] || board[i][j] != word[0]) {
            return false
        }
        
        if(word.length == 1 && word.first() == board[i][j]) {
            return true
        }

        visited[i][j] = true

        val word = word.substring(1)

        // up
        val found = searchRecursive(
            board,
            visited,
            i-1,
            j,
            word
        ) || searchRecursive(
            board,
            visited,
            i+1,
            j,
            word
        ) || searchRecursive(
            board,
            visited,
            i,
            j+1,
            word
        ) || searchRecursive(
            board,
            visited,
            i,
            j-1,
            word
        )

        visited[i][j] = false
        return found
    }
}
