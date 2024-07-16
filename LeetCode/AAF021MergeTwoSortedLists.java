package LeetCode;


// Definition for singly-linked list.


public class AAF021MergeTwoSortedLists {


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


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }


    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode();
        ListNode list3pointer = list3;
        ListNode listPrev = new ListNode();
        /*  if i just leave   as ListNode listPrev without initalization then got compile time error

        Line 83: error: variable listPrev might not have been initialized
        listPrev.next = null;

        so  added new ListNode();
        as if i just leave as ListNode listPrev and if all while blocks fails
        listPrev.next = null is wrong so we have to add listPrev = new ListNode()
        */

        /* if list1 = [1,2,4]
        and list2 =[1,3,4]
        then i got result as [1,1,2,3,4,4,0] where expected result is [1,1,2,3,4,4] so added listPrev just to remove the last node by making listPrev.next = null in the end
        */



        if(list1 == null && list2 == null){
            // without this the output is [0] in case of list1=[] and list2=[]
            return null;
        }

        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                list3.val = list1.val;
                list1 = list1.next;
            }
            else{
                list3.val = list2.val;
                list2 = list2.next;
            }
            listPrev = list3;
            list3.next = new ListNode();
            list3 = list3.next;
        }
        while(list1!=null){
            list3.val = list1.val;
            list1 = list1.next;
            listPrev = list3;

            list3.next = new ListNode();
            list3 = list3.next;
        }
        while(list2!=null){
            list3.val = list2.val;
            list2 = list2.next;
            listPrev = list3;
            list3.next = new ListNode();
            list3 = list3.next;
        }
        listPrev.next = null;


        // run in debug mode by keeping a pause step here and see value of list3Pointer.
        return list3pointer;

    }

    public static void main(String args[]){
        ListNode list1 = new ListNode();
        list1.val = 1;
        list1.next = new ListNode();
        list1.next.val = 2;

        ListNode list2 = new ListNode();
        list2.val = 1;
        list2.next = new ListNode();
        list2.next.val = 3;

        mergeTwoLists(list1,list2);


    }
}

