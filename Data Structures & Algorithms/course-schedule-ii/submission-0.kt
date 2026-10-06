class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        // 1. Build Adjacency List for ALL courses
        val graph = Array(numCourses) { mutableListOf<Int>() }
        for (pair in prerequisites) {
            val course = pair[0]
            val prereq = pair[1]
            // To take 'course', you must first take 'prereq' (prereq -> course)
            graph[prereq].add(course)
        }

        // 2. State tracking: 0 = Unvisited, 1 = Visiting (Gray), 2 = Visited (Black)
        val state = IntArray(numCourses) { 0 }
        
        // This will store our topological order in reverse
        val resultList = mutableListOf<Int>()

        // 3. Helper function for DFS and Cycle Detection
        fun hasCycle(course: Int): Boolean {
            if (state[course] == 1) return true  // Found a cycle!
            if (state[course] == 2) return false // Already fully processed safely

            state[course] = 1 // Mark as Visiting

            // Visit all downstream courses that depend on this prerequisite
            for (nextCourse in graph[course]) {
                if (hasCycle(nextCourse)) return true
            }

            state[course] = 2 // Mark as Visited
            
            // In topological sort, append to list AFTER processing all neighbors
            resultList.add(course) 
            return false
        }

        // 4. Run DFS for every single course to handle disconnected graphs
        for (i in 0 until numCourses) {
            if (state[i] == 0) {
                if (hasCycle(i)) {
                    return intArrayOf() // Cycle found, impossible to finish
                }
            }
        }

        // 5. Because we built the list from the "end" of the dependency chain backwards,
        // we reverse it to get the correct chronological order.
        return resultList.reversed().toIntArray()
    }
}
