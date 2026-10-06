/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        // two pointers one that is n behind
        var count = 0
        var head = head;
        var slower = head;
        var slow = head;
        var fast = head;

        while(fast != null) {
            if(count >= n) { // FIX:  this needs to be >=, maybe nitroduce 'slower'
                slower = slow
                slow = slow?.next
            }
            fast = fast.next
            count+=1
        }
        if(slow == head) {
            return slow?.next
        } else {
            slower?.next = slower?.next?.next
        }
        return head 
    }
}
