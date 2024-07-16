package LeetCode.ALinkedList.Medium;


import LeetCode.Daily2.AAB2816DoubleNumberInLinkedList;

public class AAA0012058FindMinimumAndMaximumNumberOfNodesBetweenCriticalPoints {
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //Constraints:
    //The number of nodes in the list is in the range [2, 105].
    //1 <= Node.val <= 105
    // 4ms, 60.4 MB beats 100% users
    static int[] nodesBetweenCriticalPoints(ListNode head) {
        int x[];
        int prev=head.val;
        int index=2;
        ListNode curr = head.next;
        int nextVal;
        int criticalPoint = -1;
        int firstCriticalPoint = -1;
        int prevCriticalPoint=-1;
        int minDistance=Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        int distance;

        while(curr.next!=null) {
            nextVal = curr.next.val;
            if (((prev < curr.val) && (curr.val > nextVal))||((prev > curr.val) && (curr.val < nextVal))) {
                criticalPoint = index;
                if (firstCriticalPoint == -1) {
                    firstCriticalPoint = criticalPoint;
                }
                //if (prevCriticalPoint != -1)&& criticalPoint > prevCriticalPoint)
                if (prevCriticalPoint != -1)//&& criticalPoint > prevCriticalPoint)
                    {
                    distance = Math.abs(criticalPoint - prevCriticalPoint);
                    if (distance < minDistance)
                        minDistance = distance;

                }
                prevCriticalPoint = criticalPoint;


            }
            prev=curr.val;
            curr = curr.next;
            index++;

        }
        maxDistance = criticalPoint - firstCriticalPoint;

        if(minDistance==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }


        return new int[]{minDistance,maxDistance};
    }



//5 ms
//60.4 MB
    // beats only 60% users
    static int[] nodesBetweenCriticalPoints1(ListNode head) {
        int x[];
        int prev=-1;
        int index=1;
        ListNode curr = head;
        int nextVal=-1;
        int criticalPoint = -1;
        int firstCriticalPoint = -1;
        int prevCriticalPoint=-1;
        int minDistance=Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;
        int distance;

        while(curr!=null) {
            if (index == 1) {
                prev = curr.val;
                curr=curr.next;
                index++;
            }
            else
            {
                if (curr.next != null) {
                    nextVal = curr.next.val;
                }
                if ((prev < curr.val) && (curr.val > nextVal)) {
                    criticalPoint = index;
                } else if ((prev > curr.val) && (curr.val < nextVal)) {
                    criticalPoint = index;
                }
                if (firstCriticalPoint == -1) {
                    firstCriticalPoint = criticalPoint;
                }
                if (prevCriticalPoint != -1 && criticalPoint > prevCriticalPoint) {
                    distance = Math.abs(criticalPoint - prevCriticalPoint);
                    if (distance < minDistance)
                        minDistance = distance;
                }
                prevCriticalPoint = criticalPoint;
                prev=curr.val;
                curr = curr.next;
                index++;

            }
        }
        maxDistance = criticalPoint - firstCriticalPoint;

        if(minDistance==Integer.MAX_VALUE){
            return new int[]{-1,-1};
        }


        return new int[]{minDistance,maxDistance};
    }




    public static void main(String[] args) {


        //[5,3,1,2,5,1,2]
        //[1,3]
        ListNode head = new ListNode(5);
        head.next = new ListNode(3);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(2);


        nodesBetweenCriticalPoints(head);



    }

}
