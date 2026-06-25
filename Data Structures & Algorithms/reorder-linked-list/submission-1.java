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
        Deque<ListNode> stack = new ArrayDeque<>();
        ListNode curr = head;
        
        while(curr != null){
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;
        int k = stack.size() / 2;
        while(k > 0){
            ListNode temp = curr.next;
            ListNode poppedEle = stack.pop();
            curr.next = poppedEle;
            poppedEle.next = temp;
            curr = temp;
            k--;
        }
        curr.next = null;
    }
}
