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
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> heap = new PriorityQueue<>((a,b) -> {
            return Integer.compare(a.val, b.val);
        });

        for (ListNode node: lists) {
            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode result = new ListNode();
        ListNode dummy = result;

        while(!heap.isEmpty()) {
            ListNode node = heap.poll();
            result.next = node;
            result = result.next;
            if (node.next != null) {
                heap.offer(node.next);
            }
        }
        return dummy.next;

        /*if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        ListNode list1 = lists[0];
        ListNode list2 = lists[1];
        ListNode result = mergeTwo(list1, list2);

        for (int i = 2; i < lists.length; i++) {
            result = mergeTwo(result, lists[i]);
        }

        return result;*/
    }

    /*ListNode mergeTwo(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode result = dummy;

        while(list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else if (list1.val > list2.val) {
                dummy.next = list2;
                list2 = list2.next;
            } 
            dummy = dummy.next;
        }

        if (list1 == null) {
            dummy.next = list2;
        } else {
            dummy.next = list1;
        }
        return result.next;
    }*/
}
