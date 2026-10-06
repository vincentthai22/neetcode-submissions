class Solution {

    class Node(
          val value: Int,
          val neighbors: MutableMap<Int, Node> = mutableMapOf(),
      ) {
          override fun equals(other: Any?) = (other as? Node)?.value == value
          override fun hashCode() = value
      }

      fun canFinish(numCourses: Int, pre: Array<IntArray>): Boolean {
          // registry: id -> Node, so we never traverse to locate a node
          val registry = mutableMapOf<Int, Node>()
          fun node(id: Int): Node = registry.getOrPut(id) { Node(id) }

          // make sure every course exists, even ones with no prereqs
          for (id in 0 until numCourses) node(id)

          // build edges: [a, b] means "b before a"  =>  edge b -> a
          for (p in pre) {
              val next = node(p[0])
              val prereq = node(p[1])
              prereq.neighbors[next.value] = next   // adjacency lives in the Node
          }

          // three-state cycle detection: 0 unseen, 1 on current path, 2 done
          val state = mutableMapOf<Int, Int>()

          fun hasCycle(n: Node): Boolean {
              when (state[n.value]) {
                  1 -> return true    // back-edge to a node on our path → cycle
                  2 -> return false   // already proven safe
              }
              state[n.value] = 1
              for (neighbor in n.neighbors.values) {
                  if (hasCycle(neighbor)) return true
              }
              state[n.value] = 2
              return false
          }

          return registry.values.none { hasCycle(it) }
      }
}
