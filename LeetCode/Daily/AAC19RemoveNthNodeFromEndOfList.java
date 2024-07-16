package LeetCode.Daily;


/*
Input: head = [1,2,3,4,5], n = 2
Output: [1,2,3,5]
Example 2:

Input: head = [1], n = 1
Output: []
Example 3:

Input: head = [1,2], n = 1
Output: [1]

 */
public class AAC19RemoveNthNodeFromEndOfList {

   public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }

       public void display() {
           //StringBuilder sb= new StringBuilder();
           ListNode current = this;
           while(current != null){
               System.out.println(current.val);

               current = current.next;

           }
       }
   }


  //approach 1 -- count no. of nodes in one iteration and remove the desired node in 2nd iteration
    // O(2n)

    // approach2 -- maintain 2 pointers and move the fast pointer first to desired location
    // next move the fast and slow until fast ! =   null
    //O(n)

    // add a dummy node as head in case we have only one node and remove it.
    // runtime 0ms beats 100% users with java
    // memory 41.49 beats 70.96% users with java
    public static ListNode removeNthFromEnd1(ListNode head, int n) {
       ListNode dummy = new ListNode(0);
       dummy.next = head;

       ListNode fast= dummy;
       ListNode slow = dummy;
       int i = 0;
       while(i<=n)
       {
           fast = fast.next;
           i++;
       }
       while(fast!= null){
           fast = fast.next;
           slow = slow.next;
       }
       slow.next = slow.next.next;

       return dummy.next;



   }


   /* approach 2 without any dummy node
      // runtime 0ms beats 100% users with java
    // memory 41.67 beats 43.22% users with java
    */
   public static ListNode removeNthFromEnd(ListNode head, int n) {

       ListNode fast= head;
       ListNode slow = head;
       int i = 0;
       while(i<n)
       {
           fast = fast.next;
           i++;
       }
       if(fast == null){
           return slow.next;
       }
       while(fast.next!= null){
           fast = fast.next;
           slow = slow.next;
       }
       slow.next = slow.next.next;

       return head;



   }


    public static void main(String args[]){

       ListNode list1 = new ListNode();
       list1.val = 1;
       list1.next = new ListNode();
       list1.next.val = 2;
       list1.next.next = new ListNode();
       list1.next.next.val = 3;
       list1.next.next.next = new ListNode();
       list1.next.next.next.val = 4;
       list1.next.next.next.next = new ListNode();
       list1.next.next.next.next.val = 5;

       System.out.println("initial list is ");
       list1.display();
       System.out.println("next is ");

       list1 = removeNthFromEnd(list1,4);

       list1.display();

       System.out.println("next");

       list1 = removeNthFromEnd(list1,3);
       list1.display();

       System.out.println("next");

       list1 = removeNthFromEnd(list1,3);
       list1.display();

        System.out.println("next");

        list1 = removeNthFromEnd(list1,1);
        list1.display();

        System.out.println("next");

        list1 = removeNthFromEnd(list1,1);
        if (list1 == null){
            System.out.println("list empty");
        }




   }



    }
