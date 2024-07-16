package LeetCode.Daily2;

public class AAB2816DoubleNumberInLinkedList {


     // Definition for singly-linked list.
     public static class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

     public ListNode doubleIt(ListNode head) {
         ListNode cur = head;
         ListNode prev = null;
         while(cur!= null){
             cur.val =cur.val*2;
             if(cur.val>8){
                 if(prev == null){
                     prev = new ListNode(0);
                     prev.next = head;
                     head = prev;
                 }
                 cur.val = cur.val %10;
                 prev.val = prev.val+1;
             }
             prev = cur;
             cur = cur.next;
         }
         return head;

     }

    public static void main(String[] args) {
         ListNode head = new ListNode(5);
         head.next = new ListNode(6);
         head.next.next = new ListNode(5);

         AAB2816DoubleNumberInLinkedList obj = new AAB2816DoubleNumberInLinkedList();
         head = obj.doubleIt(head);
         System.out.println("debug");



    }
}