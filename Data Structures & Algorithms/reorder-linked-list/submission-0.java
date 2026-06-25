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
    public ListNode reverseLL(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode alreadyReversed = reverseLL(head.next);
        head.next.next = head;
        head.next = null;
        return alreadyReversed;
    }
    public ListNode findMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void reorderList(ListNode head) {
        ListNode mid = findMid(head);
        ListNode reverseHead = reverseLL(mid);
        ListNode curr = head;
        while(reverseHead.next != null){
            ListNode tempX = curr.next;
            curr.next = reverseHead;
            ListNode tempY = reverseHead.next;
            reverseHead.next = tempX;
            reverseHead = tempY;
            curr = tempX;
        }
    }
}
