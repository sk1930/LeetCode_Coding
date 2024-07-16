package LeetCode.ALinkedList.Medium;


import java.util.Arrays;

public class AAA2181MergeNodesInBetweenZeros {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode firstPointer=head.next;
        ListNode nextPoint=firstPointer;
        int sum = 0;
        while(nextPoint!=null){

            sum+=nextPoint.val;
            if(nextPoint.val==0){
                firstPointer.val=sum;
                if(nextPoint.next!=null){
                    firstPointer=firstPointer.next;
                }
                sum=0;
            }
            nextPoint=nextPoint.next;
        }
        firstPointer.next=null;



        return head.next;

    }
    public static void main(String[] args) {
        int[] x = {1,2,2,1};

        int[] y = {2,2};





    }

}
