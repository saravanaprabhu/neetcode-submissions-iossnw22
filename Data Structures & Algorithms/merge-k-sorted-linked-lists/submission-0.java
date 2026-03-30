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
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((o1,o2) -> {
           return o1.val - o2.val;
        });
        ListNode dummy = new ListNode(-1);
        for(ListNode list:lists) {
            heap.add(list);
        }
        ListNode finalList = dummy;
        while(!heap.isEmpty()) {
            ListNode node = heap.poll();
            finalList.next = node;
            if(node.next != null) {
                heap.add(node.next);
            }
            finalList = finalList.next;
        }
        return dummy.next;
    }
}
