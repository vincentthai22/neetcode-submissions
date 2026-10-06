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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        if(list2 == null) return list1;
        if(list1 == null) return list2;

        ListNode trav1;
        ListNode trav2;
        
        if(list1.val < list2.val) {
            trav1 = list1;
            trav2 = list2;
        } else {
            trav1 = list2;
            trav2 = list1;
        }

        ListNode newHead = trav1.val <= trav2.val ? trav1 : trav2;
        

        while(trav1 != null && trav2 != null) {
            trav1 = travUntilLessThan(trav1, trav2.val);
            ListNode next = trav1.next;
            trav1.next = trav2;
            trav1 = next;

            if(trav1 == null) continue;
            trav2 = travUntilLessThan(trav2, trav1.val);
            next = trav2.next;
            trav2.next = trav1;
            trav2 = next;
        }
        return newHead;
    }

    
    private ListNode travUntilLessThan(ListNode trav, int otherVal) {
        while( trav.next != null && trav.next.val <= otherVal) trav = trav.next;
        return trav;
    }
}