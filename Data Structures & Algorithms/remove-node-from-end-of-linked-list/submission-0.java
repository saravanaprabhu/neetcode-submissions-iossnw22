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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = length(head);
        int pos = size - n;
        if(pos == 0) return head.next;
        ListNode p = head, prev = null, next= null;
        while(pos-- > 0) {
            prev = p;
            p = p.next;
        }
        if(p!=null) {
            prev.next = p.next;
        }
        return head;
    }

    int length(ListNode head) {
        int count = 0;
        ListNode p = head;
        while(p != null) {
            p = p.next;
            count++;
        }
        return count;
    }
}
