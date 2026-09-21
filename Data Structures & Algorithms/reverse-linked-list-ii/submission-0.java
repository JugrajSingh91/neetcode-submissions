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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // find left
        // find right

        //left should point to the node to the right of right
        //node to the left of left should point to  right

        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode leftNode  = dummy;
        ListNode rightNode = dummy;
        
        for (int i = 0; i < left-1; i++) {
            leftNode = leftNode.next;
        }
        ListNode start = leftNode;
        leftNode = leftNode.next;

        for (int i = 0; i < right; i++) {
            rightNode = rightNode.next;
        }
        ListNode end = rightNode.next;

        ListNode prev = end;
        while(leftNode != end) {
            ListNode next = leftNode.next;
            leftNode.next = prev;
            prev = leftNode;
            leftNode = next;
        }
        start.next = rightNode;
        return (left > 1)? head : rightNode;
        
     //             prev   left  next
        //  null  <- A  ->  B  ->  C

    }
}