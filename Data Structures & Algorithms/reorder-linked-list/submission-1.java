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
    public void reorderList(ListNode head) {
        ListNode og = head;
        ListNode dummy = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        ListNode tail = reverse(slow.next);
        slow.next = null;
        boolean flag = true;
        while(tail!=null) {
            ListNode temp1 = head.next;
            ListNode temp2 = tail.next;

            head.next = tail;
            tail.next = temp1;

            head = temp1;
            tail = temp2;
        }
    }   

    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        while(current != null) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
}
