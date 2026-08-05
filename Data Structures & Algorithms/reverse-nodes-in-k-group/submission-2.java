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
        ListNode count = head;
        int n = 0;
        while(count!=null) {
            count = count.next;
            n++;
        }
        if (n < k) return head;
        return recurse(head, k, n/k);
        
    }

    ListNode recurse(ListNode head, int k, int count) {
        if (count == 0) return head;

        ListNode prev = null;
        ListNode current  = head;
        ListNode prevGroup = head;
        int group = k;
        while(k > 0) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            k--;
        }
        prevGroup.next = recurse(current, group, count - 1);
        return prev;
    }
}
