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
        ListNode t = head;
        ListNode before = null;
        int pos = 1;

        while(pos < left){
            before = t;
            t = t.next;
            pos++;
        }

        int times = right - left +1;
        ListNode curr = t;
        ListNode prev = null;

        while(times>=1){
            ListNode Next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = Next;
            times--;
        }

        t.next = curr;
        if(before == null){
            return prev;
        }else{
            before.next = prev;
            return head;
        }
    }
}