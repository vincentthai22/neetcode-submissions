class Solution {
    fun checkInclusion(s1: String, s2: String): Boolean {
        val countMap = mutableMapOf<Char, Int>()

        s1.forEach {
            countMap[it] = countMap.getOrPut(it, {0}) + 1
        }
        s2.forEachIndexed { index, char ->
            if((countMap[char] ?: 0) > 0) {
                //found, fan out
                if(isPermutationFrom(index, s2, countMap.toMutableMap(), s1.length)) {
                    return true
                }
            }
        }

        return false
    }

    private fun isPermutationFrom(start: Int, word: String, countMap: MutableMap<Char, Int>, count: Int): Boolean {
        var count = count-1
        var curr = start

        val currChar = word[curr]
        countMap[currChar] = countMap[currChar]!! - 1

        // println("startAt: ${word[start]}")

        var left = curr
        var right = curr
        while(count > 0) {
            if(left-1 > 0) {
                if(countMap[word[left-1]] != null) {
                    val charCount = countMap[word[left-1]]!!
                    if(charCount > 0) {
                        //found a match
                        // println("found match: ${word[left-1]}")
                        left -= 1
                        countMap[word[left]] = charCount - 1
                        count--
                        continue
                    }
                }
            }

            if(right+1 < word.length) {
                if(countMap[word[right+1]] != null) {
                    val charCount = countMap[word[right+1]]!!
                    if(charCount > 0) {
                        // println("found match: ${word[right+1]}")
                        //found a match
                        right+=1
                        countMap[word[right]] = charCount - 1
                        count--
                        continue
                    }
                }
            }
            return false
        }
        return true
    }
}
