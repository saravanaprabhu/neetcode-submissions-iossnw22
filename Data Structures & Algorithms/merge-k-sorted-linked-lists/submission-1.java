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
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((l1, l2) -> {
                return l1.val - l2.val;
            }
        );
        for(int i = 0; i< lists.length;i++) {
            pq.offer(lists[i]);
        }
        ListNode tmp = new ListNode(-1);
        ListNode traverse = tmp;
        while(!pq.isEmpty()) {
            ListNode curr = pq.poll();
            traverse.next = curr;
            ListNode nextNode = curr.next;
            if(nextNode != null) {
                pq.offer(nextNode);
            }
            curr.next = null;
            traverse = traverse.next;
        }
        
        return tmp.next;
    }
}
