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
    ListNode mergeSortedLists(ListNode l1, ListNode l2){
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        if(l1.val <= l2.val){
            l1.next = mergeSortedLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeSortedLists(l1, l2.next);
            return l2;
        }
    }
    ListNode divideAndMergeLists(ListNode[] lists, int start, int end){
        if(start == end){
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode l1 = divideAndMergeLists(lists, start, mid);
        ListNode l2 = divideAndMergeLists(lists, mid + 1, end);
        return mergeSortedLists(l1, l2);
    }
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        return divideAndMergeLists(lists, 0, lists.length - 1);
    }
}
