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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = head;
        int n = 0;
        while(dummy != null) {
            n++;
            dummy = dummy.next;
        }

        ListNode[][] headTailPairs = new ListNode[n/k][2];
        
        ListNode current = head; 
        for (int i = 0; i < n/k; i++) {
            headTailPairs[i][1]  = current;
            ListNode prev = null;

            int len = 1;
            while(len <= k) { 
                ListNode next = current.next;
                current.next = prev; 
                prev = current;
                current = next;
                len++;
            } //3->2->1->null // current == 4, prev = 3
             headTailPairs[i][0] = prev;
        }
        for (int i = 1; i < headTailPairs.length; i++) {
            headTailPairs[i-1][1].next = headTailPairs[i][0];
        }
        if (current != null) {
            headTailPairs[n/k -1][1].next = current;
        }


        return headTailPairs[0][0];
    }
}
