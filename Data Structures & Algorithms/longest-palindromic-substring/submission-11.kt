class Solution {
    fun longestPalindrome(s: String): String {

    var longest = s.first().toString()
    s.forEachIndexed { index, ch ->
        isStartOfPalidrome(s, index)?.let { type ->
            when(type) {
                PalindromeStartType.None -> null
                PalindromeStartType.DoubleLetter -> countPalindrome(s, index, index+1)
                PalindromeStartType.Mirror -> countPalindrome(s, index-1, index+1)
                PalindromeStartType.Both -> if(s.length % 2 == 0) {
                    countPalindrome(s, index, index+1)
                } else {
                    countPalindrome(s, index-1, index+1)
                }
            }?.let { (left, right) ->
                if(right - left + 1 > longest.length) {
                    longest = s.substring(left..right)
                }
            }
        }
    }
    return longest
}

private fun countPalindrome(s: String, left: Int, right: Int): Pair<Int, Int> {
    var left = left
    var right = right
    var leftChar = s[left]
    var rightChar = s[right]
    while(left-1 in s.indices && right+1 in s.indices && s[left-1] == s[right+1]) {
        
        leftChar = s[--left]
        rightChar = s[++right]
    }
    println("left: $left right: $right")

    return Pair(left, right)
}

enum class PalindromeStartType {

    None,
    DoubleLetter,
    Mirror,
    Both
}

fun isStartOfPalidrome(s: String, index: Int): PalindromeStartType {
    val nextIndex = index+1
    val prevIndex = index-1

    if(nextIndex > s.lastIndex) {
        return PalindromeStartType.None
    }

    val curr = s[index]
    val next = s[nextIndex]
    val prev = if (prevIndex < 0) null else s[prevIndex]
    return if(curr == next && prev == next) {
        PalindromeStartType.Both
    } else if(prev == next){
        PalindromeStartType.Mirror
    } else if (curr == next) {
        PalindromeStartType.DoubleLetter
    } else {
        PalindromeStartType.None
    }
}
}
