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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return head;

        ListNode trav = head.next;
        ListNode trail = head;

        while(trav != null) {
            ListNode temp = trav;
            trav = trav.next;
            temp.next = trail;
            trail = temp;
        }
        head.next = null;
        return trail;

    }
}
