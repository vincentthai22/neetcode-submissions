/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null || slow != null) {
            fast = fast.next;
            if(slow != null) {
                slow = slow.next;
            }
            if(slow == null) continue;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }
}
