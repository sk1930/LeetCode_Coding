package LeetCode.Set.Medium;

import LeetCode.Daily.AAC19RemoveNthNodeFromEndOfList;

import java.util.*;


public class AAA001_1110_DeleteNodesAndReturnForest {

   static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
 }
    List<TreeNode> result = new ArrayList<TreeNode>();
    Set<Integer> todeleteSet = new HashSet<>();
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int i:to_delete){
            todeleteSet.add(i);
        }
        addCurrentNode(root,true);

       return result;
    }
    private TreeNode addCurrentNode(TreeNode node,boolean isParentDeleted){
        if(node==null){
            return null;
        }
        boolean present = todeleteSet.contains(node.val);
        if(isParentDeleted && !present){
            // if parent is deleted and the current node is not present in te list to e deleted only then add this node to the result.
            result.add(node);
        }
        node.left = addCurrentNode(node.left,present);
        node.right = addCurrentNode(node.right,present);
        return present?null:node;
    }

    public static void main(String[] args) {
        TreeNode list1 = new TreeNode();
        list1.val = 1;
        list1.left = new TreeNode();
        list1.left.val = 2;
        list1.right = new TreeNode();
        list1.right.val = 3;
        list1.left.left = new TreeNode();
        list1.left.left.val = 4;
        list1.left.right = new TreeNode();
        list1.left.right.val = 5;


        list1.right.left = new TreeNode();
        list1.right.left.val = 6;

        list1.right.right = new TreeNode();
        list1.right.right.val = 7;



        AAA001_1110_DeleteNodesAndReturnForest obj = new AAA001_1110_DeleteNodesAndReturnForest();
        System.out.println(obj.delNodes(list1,new int[]{3,5}));

    }
}