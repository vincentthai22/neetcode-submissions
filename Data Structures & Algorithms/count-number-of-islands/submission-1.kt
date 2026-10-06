class Solution {
    fun numIslands(grid: Array<CharArray>): Int {
        //impl using dfs
        // recursively clear out zeroes
        var count = 0
        for(col in 0 until grid.size) {
            for(row in 0 until grid[col].size) {
                if(grid[col][row] == LAND) {
                    traverseIsland(grid, row, col)
                    count++
                }
            }
        }
        return count
    }

    val EMPTY = '0'
    val LAND = '1'

    fun traverseIsland(grid: Array<CharArray>, x: Int, y: Int) {

        if(y < 0) return
        if(y > grid.size-1) return
        if(x < 0) return
        if(x > grid[y].size-1) return

        if(grid[y][x] == EMPTY) {
            return
        } else {
            grid[y][x] = EMPTY
            //traverse all directions and clear
            traverseIsland(grid, x+1, y)
            traverseIsland(grid, x-1, y)
            traverseIsland(grid, x, y+1)
            traverseIsland(grid, x, y-1)
        }
    }
}
