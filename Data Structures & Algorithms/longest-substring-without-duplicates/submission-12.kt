class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        val map = hashMapOf<Char, Int>();
        var head = 0;
        var tail = 0;
        var longest = 0;

        while(head <= tail && tail < s.length) {
            
            var curr = s[tail];
            var count = map[curr] ?: 0

            // doesn't exist
            if(count == 0) {
                map[curr] = 1 
            } else {
                var newHead = travUntilNext(s, head, curr) + 1
                clearMapBetween(map, head until newHead, s)
                head = newHead
                map[curr] = 1
            }
            println("head: $head tail: $tail longest: $longest curr:$curr currValue: ${map[curr]}")
            longest = max(tail - head + 1, longest)
            tail++
        }
        
    return longest;
    }

    private fun clearMapBetween(map: HashMap<Char, Int>, range: IntRange, s: String) {
        for(i in range) {
            map[s[i]] = 0
        }
    }

    private fun travUntilNext(s: String, head: Int, currentChar: Char): Int {
        var trav = head;
        while(true) {
            var travChar = s[trav]
            if(travChar == currentChar) {
                //found
                return trav;
            } else {
                //keep traversing
                trav++
            }
        }
    }
}
