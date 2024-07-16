package LeetCode.Daily2;


//Runtime 0 ms Beats 100.00% of users with Java Memory 41.17 MB Beats 75.37% of users with Java
public class AAA404SumOfLeftLeaves {


    /*Given the root of a binary tree, return the sum of all left leaves.
A leaf is a node with no children. A left leaf is a leaf that is the left child of another node.
    Input: root = [3,9,20,null,null,15,7]
 */



     //Definition for a binary tree node.
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
      int sum;
    public int sumOfLeftLeaves(TreeNode root) {
          return traversal(root,sum);

    }
    public int traversal(TreeNode root,int sum){
        if(root==null){
            return 0;
        }
        if(root.left!=null && root.left.left ==null && root.left.right ==null){
            return sum+root.left.val+traversal(root.right,sum);
        }
        return sum+traversal(root.left,sum)+traversal(root.right,sum);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(6,new TreeNode(6),new TreeNode(7));
        root.right = new TreeNode(8,new TreeNode(7),new TreeNode(6));

        AAA404SumOfLeftLeaves obj = new AAA404SumOfLeftLeaves();

        System.out.println(obj.sumOfLeftLeaves(root));

    }


}
