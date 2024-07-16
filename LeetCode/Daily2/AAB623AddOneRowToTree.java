package LeetCode.Daily2;

public class AAB623AddOneRowToTree {




    /*
     * Definition for a binary tree node.
     */
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

    public TreeNode addOneRow(TreeNode root, int val, int depth){
        root = traversal(root,val,depth,1);
        // assigning root is needed as if root itself is changed by adding a node at the root itself.


        return root;
    }



    public TreeNode traversal(TreeNode node, int val, int depth, int currentDepth){
        if(node == null){
            return null;
        }
        if(depth==1){

            TreeNode newNode = new TreeNode(val);
            newNode.left = node;
            node = newNode;
            return node;
        }

        if(depth==currentDepth+1){
            TreeNode newNode = new TreeNode(val);
            newNode.left = node.left;
            node.left = newNode;

            //if(node.right != null){
                TreeNode newNode1 = new TreeNode(val);
                newNode1.right = node.right;
                node.right = newNode1;
            //}

        }
        traversal(node.left,val,depth,currentDepth+1);
        traversal(node.right,val,depth,currentDepth+1);

        return node;

    }


    public static void main(String[] args) {
        AAB623AddOneRowToTree obj = new AAB623AddOneRowToTree();





        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(6);//,new TreeNode(6),new TreeNode(7));
        root.right = new TreeNode(8);//,new TreeNode(7),new TreeNode(6));


        System.out.println(obj.addOneRow(root,1,2));



        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2,new TreeNode(4),null);
        root1.right = new TreeNode(3);//,new TreeNode(7),new TreeNode(6));
        obj.addOneRow(root1,5,4);





        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2,new TreeNode(4),null);
        root2.right = new TreeNode(3);//,new TreeNode(7),new TreeNode(6));
        obj.addOneRow(root2,5,1);



    }



}