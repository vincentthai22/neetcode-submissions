class Solution {
    val EMPTY = '.'
    fun characterReplacement(s: String, k: Int): Int {
      val count = HashMap<Char, Int>()
      var left = 0
      var maxFreq = 0
      var longest = 0
  
      for (right in s.indices) {
          val c = s[right]
          count[c] = (count[c] ?: 0) + 1
          maxFreq = maxOf(maxFreq, count[c]!!)

          // too many chars to replace? slide left forward by one
          if (right - left + 1 - maxFreq > k) {
              count[s[left]] = count[s[left]]!! - 1
              left++
          }
          longest = maxOf(longest, right - left + 1)
      }
      return longest
  }
}
