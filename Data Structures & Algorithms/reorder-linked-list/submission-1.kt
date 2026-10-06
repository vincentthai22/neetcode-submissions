/**
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class Solution {
    fun reorderList(head: ListNode?): Unit {
        if (head?.next == null) return

        // Step 1: Find middle using slow/fast pointers
        var slow = head
        var fast = head
        while (fast?.next != null && fast.next?.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }

        // Step 2: Reverse second half of the list
        var secondHalf = reverse(slow?.next)
        slow?.next = null // Terminate first half

        // Step 3: Merge first half and reversed second half
        var firstHalf = head
        while (secondHalf != null) {
            val tmp1 = firstHalf?.next
            val tmp2 = secondHalf.next

            firstHalf?.next = secondHalf
            secondHalf.next = tmp1

            firstHalf = tmp1
            secondHalf = tmp2
        }
    }

    private fun reverse(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var curr = head
        while (curr != null) {
            val nextTemp = curr.next
            curr.next = prev
            prev = curr
            curr = nextTemp
        }
        return prev
    }
}
