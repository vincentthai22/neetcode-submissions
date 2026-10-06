const val ROT = 2
const val FRESH = 1
const val EMPTY = 0
class Solution {

    data class Point(val x: Int, val y: Int)
    fun orangesRotting(grid: Array<IntArray>): Int {
        var rottingPoints = findRottingPoints(grid)
        var stillHasNeighbors = false
        var time = 0

        println("rottingPoints: $rottingPoints")
        
        do {
            var newPoints = mutableListOf<Point>()
            for(point in rottingPoints) {
                val left = Point(point.x-1, point.y)
                val right = Point(point.x+1, point.y)
                val top = Point(point.x, point.y-1)
                val bottom = Point(point.x, point.y+1)
                rotOverTime(grid, left)?.let {
                    newPoints.add(it)
                }
                rotOverTime(grid, right)?.let {
                    newPoints.add(it)
                }
                rotOverTime(grid, top)?.let {
                    newPoints.add(it)
                }
                rotOverTime(grid, bottom)?.let {
                    newPoints.add(it)
                }
            }
            if(newPoints.isNotEmpty()) {
                rottingPoints = newPoints
                stillHasNeighbors = true
                time++
            } else {
                stillHasNeighbors = false
            }
        } while(stillHasNeighbors)

        return if(isImpossibleAfterRot(grid)) {
            -1
        } else {
            time
        } 
    }


    fun findRottingPoints(grid: Array<IntArray>): List<Point> {
        val rottingPoints = mutableListOf<Point>()
        for(y in 0 until grid.size) {
            for(x in 0 until grid[y].size) {
                if(grid[y][x] == ROT) rottingPoints.add(Point(x, y))
            }
        }
        return rottingPoints
    }

    // returns has fresh neighbors
    fun rotOverTime(grid: Array<IntArray>, start: Point): Point? {
        if(start.y !in 0 until grid.size) return null
        if(start.x !in 0 until grid[start.y].size) return null

        return when(grid[start.y][start.x]) {
            FRESH -> {
                grid[start.y][start.x] = ROT //rot
                return start
                // if(grid[start.y-1][start.x] == FRESH ||
                //     grid[start.y+1][start.x] == FRESH ||
                //     grid[start.y][start.x-1] == FRESH ||
                //     grid[start.y][start.x+1] == FRESH) {
                //         return start
                //     } else {
                //         return null
                //     }
            }
            else -> null
        }
    }

    // only call after rot is done
    fun isImpossibleAfterRot(grid: Array<IntArray>): Boolean {
        for(y in 0 until grid.size) {
            for(x in 0 until grid[y].size) {
                if(grid[y][x] == FRESH) return true //found unreachable
            }
        }

        return false
    }
}
