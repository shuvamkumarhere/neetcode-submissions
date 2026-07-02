class Solution {
    // private int getLength(ListNode head){
    //     int n = 0;
    //     while(head != null){
    //         head = head.next;
    //         n++;
    //     }
    //     return n;
    // }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode temp = head;
        while(n > 0){
            temp = temp.next;
            n--;
        }

        while (temp != null) {
            prev = prev.next; 
            temp = temp.next;
        }

        prev.next = prev.next.next;
        
        return dummy.next;
    }
}