/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummyHead = new Node(-1);
        //old to new Map
        HashMap<Node, Node> nodesMap = new HashMap<Node, Node>();
        Node traverseOld = head;
        Node prevNode = null;
        Node traverseNew = dummyHead;
        while(traverseOld != null) {
            Node newNode = new Node(traverseOld.val);
            if(prevNode != null) {
                prevNode.next = newNode;
            }
            nodesMap.put(traverseOld, newNode );
            traverseOld = traverseOld.next;
            traverseNew.next = newNode;
            traverseNew = traverseNew.next;
        }
        traverseOld = head;
        traverseNew = dummyHead.next;
        while(traverseOld != null) {
            Node random = nodesMap.get(traverseOld.random);
            traverseNew.random = random;
            traverseOld = traverseOld.next;
            traverseNew = traverseNew.next;
        }
        return dummyHead.next;
    }
}
