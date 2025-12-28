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
    public static void reverse(ListNode left,int size){
        ListNode curr = left;
        ListNode prev = null;

        while(size>0){
            ListNode nex = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nex;
            size--;
        }  
        return;
    }


    public ListNode swapPairs(ListNode head) {
        if(head ==null){
            return null;
        }

        ListNode left = head;
        ListNode res = null;
        ListNode prevLeft = null;
        ListNode right;
        int size = 2;

        while(true){
            right = left;
            for(int i= 0;i<size-1;i++){
                if(right==null){
                    break;
                }
                right = right.next;
            }

            if(right != null){
                ListNode nextLeft = right.next;
                reverse(left,size);
                
                if(prevLeft!=null){
                    prevLeft.next = right;
                    prevLeft = left;
                }       
                if(res == null){
                    res = right;
                }
                left.next = nextLeft;
                prevLeft = left;
                left = nextLeft;
            }
            else{
                    if(prevLeft!=null){
                        prevLeft.next = left;
                    }
                    if(res == null){
                        res = left;
                    }

                    break;
            }
        }

        return res;
    }
}