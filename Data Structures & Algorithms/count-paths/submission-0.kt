class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
      val matrix = mutableListOf<MutableList<Int>>()

      for (i in 0 until m) {
          matrix.add(mutableListOf<Int>())
          for (j in 0 until n) {
              matrix[i].add(
                  if (i == 0 || j == 0) 1
                  else matrix[i - 1][j] + matrix[i][j - 1]
              )
          }
      }
      return matrix.last().last()
  }
}
