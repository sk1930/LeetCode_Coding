package LeetCode.Daily2;

public class AAA2331EvaluateBooleanBinaryTree {

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

    class Solution {
        public boolean evaluateTree(TreeNode root) {
            if(root.val==1||root.val==0){
                return (root.val==1);
            }
            boolean leftVal = evaluateTree(root.left);
            boolean rightVal = evaluateTree(root.right);
            return (root.val==3)?(leftVal&&rightVal):(leftVal||rightVal);
        }

        public static void main(String[] args) {

        }
    }


}