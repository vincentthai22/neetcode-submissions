class Solution {
    fun longestCommonSubsequence(text1: String, text2: String): Int {
      val m = text1.length
      val n = text2.length
      val dp = Array(m + 1) { IntArray(n + 1) }   // row/col 0 = empty prefix = 0

      for (i in 1..m) {
          for (j in 1..n) {
              dp[i][j] = if (text1[i - 1] == text2[j - 1])
                  dp[i - 1][j - 1] + 1                    // chars match → extend diagonal
              else
                  maxOf(dp[i - 1][j], dp[i][j - 1])       // skip one char from either string
          }
      }
      return dp[m][n]
  }

    private fun MutableMap<Char, Int>.fill(s: String) {
        for(c in s) {
            val mapValue = this.get(c)?: 0
            put(c, mapValue + 1)
        }
    }
}
