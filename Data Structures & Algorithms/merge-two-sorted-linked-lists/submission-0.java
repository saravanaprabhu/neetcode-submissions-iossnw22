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
        ListNode l3Head = new ListNode(-1);
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode p1 = list1, p2= list2, l3 = l3Head;
        while(p1 != null || p2!= null ) {
            if(p1 != null && p2 != null ) {
                if(p1.val <= p2.val) {
                    l3.next = p1;
                    p1= p1.next;
                } else {
                    l3.next = p2;
                    p2 = p2.next;
                }
            } else if(p1 == null) {
                l3.next = p2;
                p2 = p2.next;
            } else if(p2 ==null) {
                l3.next = p1;
                p1 = p1.next;
            }
            l3 = l3.next;
        }
        return l3Head.next;
    }
}