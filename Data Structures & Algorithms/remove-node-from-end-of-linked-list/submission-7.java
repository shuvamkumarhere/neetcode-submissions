class Solution {
    private int getLength(ListNode head){
        int n = 0;
        while(head != null){
            head = head.next;
            n++;
        }
        return n;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head.next == null) return null;
        int l = getLength(head);
        if(l == n){
            return head.next;
        }
        int idx = l - n;
        ListNode prev = null;
        ListNode temp = head;
        
        while (idx > 0) {
            prev = temp; 
            temp = temp.next;
            idx--;
        }

        prev.next = temp.next;
        
        return head;
    }
}