package LeetCode.Daily2;

public class AAB237DeleteNodeInLinkedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        // change current node value to next node value and skip next node
            node.val = node.next.val;
            node.next = node.next.next;


    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        AAB237DeleteNodeInLinkedList obj = new AAB237DeleteNodeInLinkedList();

        obj.deleteNode(node.next);
        System.out.println(node);
    }
}