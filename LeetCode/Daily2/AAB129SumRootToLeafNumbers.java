package LeetCode.Daily2;

public class AAB129SumRootToLeafNumbers {



    // Definition for a binary tree node.
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
        public int sumNumbers(TreeNode root) {
         return traversal(root,sum);

        }

        public int traversal(TreeNode root,int sum){
         if(root ==null)
         {
             return 0;
         }
         if(root.left ==null && root.right == null){
             return (sum*10)+root.val;
         }
         return traversal(root.left, (sum*10)+root.val)+traversal(root.right,(sum*10)+root.val);
        }



    public static void main(String[] args) {

        AAB129SumRootToLeafNumbers obj = new AAB129SumRootToLeafNumbers();


            TreeNode root = new TreeNode(4);
        root.left = new TreeNode(6);//,new TreeNode(6),new TreeNode(7));
        root.right = new TreeNode(8);//,new TreeNode(7),new TreeNode(6));


        System.out.println(obj.sumNumbers(root));


        TreeNode root1 = new TreeNode(4);

        root1.left = new TreeNode(9,new TreeNode(5),new TreeNode(1));
        root1.right = new TreeNode(0);//,new TreeNode(7),new TreeNode(6));


        System.out.println(obj.sumNumbers(root1));




        TreeNode root2 = new TreeNode(1);

        root2.left = new TreeNode(0);
        root2.right = null;//,new TreeNode(7),new TreeNode(6));


        System.out.println(obj.sumNumbers(root2));
    }
}
