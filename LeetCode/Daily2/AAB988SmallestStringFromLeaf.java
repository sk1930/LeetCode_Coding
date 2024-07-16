package LeetCode.Daily2;

public class AAB988SmallestStringFromLeaf {

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


    String smallest = null;
    public String smallestFromLeaf(TreeNode root) {

        depthFirstSearch(root,new StringBuilder());
        return smallest;
    }
    public void depthFirstSearch(TreeNode node, StringBuilder stringBuilder){
        if (node == null){
            return;
        }
        stringBuilder.insert(0,(char)('a'+node.val));

        // we reached a leaf
        if(node.left ==null && node.right == null){
            compareStrings(stringBuilder.toString());
        }
        else {
            depthFirstSearch(node.left, stringBuilder);

            depthFirstSearch(node.right,stringBuilder);
        }
        stringBuilder.deleteCharAt(0);
        // delete the char as we move back from bottom to top.
        // if root is a , left child is b and right child is c
        // after visiting left child, stringBuilder is ba,
        // to visit the right child, string builder should be a alone.



        /* if root is
                        z
                  b                 d
            b           d       a       c


          after traversing zbd, string builder should be z, by deleting d first and next b.

         */
    }

    public void compareStrings(String s){
        if(smallest == null || (s.compareTo(smallest)<0)){
            smallest = s;
        }
    }


    public static void main(String[] args) {
        AAB988SmallestStringFromLeaf obj = new AAB988SmallestStringFromLeaf();


        TreeNode root = new TreeNode(0);
        root.left = new TreeNode(1);//,new TreeNode(6),new TreeNode(7));
        root.right = new TreeNode(2);//,new TreeNode(7),new TreeNode(6));

        System.out.println(obj.smallestFromLeaf(root)); // output should be ba



        TreeNode root1 = new TreeNode(25);
        root1.left = new TreeNode(1,new TreeNode(1),new TreeNode(3));
        root1.right = new TreeNode(3,new TreeNode(0),new TreeNode(2));

        System.out.println(obj.smallestFromLeaf(root1));  // output should be adz


    }

}
