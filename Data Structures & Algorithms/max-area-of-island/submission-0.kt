const val LAND = 1
const val WATER = 0
class Solution {
    data class Point(val x: Int,val y: Int)

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var max = 0
        for(y in 0 until grid.size) {
            for(x in 0 until grid[y].size) {
                if(grid[y][x] == LAND) {
                    //dfs find max count
                    max = maxOf(countArea(grid, Point(x,y)), max)
                } else {
                    //continue
                }
            }
        }
        return max
    }

    fun countArea(grid: Array<IntArray>, start: Point): Int {

        if(start.y !in 0 until grid.size) return 0
        if(start.x !in 0 until grid[start.y].size) return 0

        val curr = grid[start.y][start.x]
        if(curr == WATER) return 0
        if(curr == LAND) {
            grid[start.y][start.x] = WATER
            return 1 + countArea(grid, Point(start.x-1, start.y)) +
            countArea(grid, Point(start.x+1, start.y)) +
            countArea(grid, Point(start.x, start.y-1)) +
            countArea(grid, Point(start.x, start.y+1)) 
        }
        return 0
    }


}
