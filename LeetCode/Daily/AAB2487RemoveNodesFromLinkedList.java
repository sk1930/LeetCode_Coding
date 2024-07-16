package LeetCode.Daily;


import LeetCode.Daily2.AAB2816DoubleNumberInLinkedList;

public class AAB2487RemoveNodesFromLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode removeNodes(ListNode head) {
        if(head==null || head.next == null){
            return head;
        }
        ListNode curr = reverse(head);
        ListNode curr1=curr;
        ListNode next = curr.next;

        while(next!=null){
            if(next.val<curr.val){
                curr.next = next.next;
            }else{
                curr= curr.next;
            }
            next = next.next;
        }
        return reverse(curr1);
    }

    public ListNode reverse(ListNode head){
        ListNode curr = head, next= head.next,prev=null;
        while(next!=null){
            curr.next=prev;
            prev=curr;
            curr=next;
            next=next.next;
        }
        curr.next=prev;
        return curr;
    }
    public static void main(String args[]){
        ListNode head = new ListNode(5);
        head.next = new ListNode(6);
        head.next.next = new ListNode(5);

        AAB2487RemoveNodesFromLinkedList obj = new AAB2487RemoveNodesFromLinkedList();
        head = obj.removeNodes(head);

        System.out.println("Debug");


    }
}