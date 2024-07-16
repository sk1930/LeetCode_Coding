package Geeks;

public class AAcBinarySearchTree {

    // insert breakpoints at each tree.insert(10) and debug and run to see the values at each breakpoint


    class Node{
        public int key;
        public Node left,right;
        Node(int item){
            key = item;
            left=null;
            right = null;
        }
    }
    Node root;
    AAcBinarySearchTree(){root = null;}


    void insert(int item){
        root = insertRec(root,item);

    }
    public Node insertRec(Node root, int item){

    if (root==null){
        root = new Node(item);

        return root;
    }
    else if (item <= root.key){
        // we r updating root.left and root.right but not actual root

        root.left = insertRec(root.left,item);

    }
    else if (item > root.key){
        root.right = insertRec(root.right,item);

    }
    // returning the root whatever is received
        // Return the (unchanged) node pointer


        return root;
    }

    void inorder(Node root){
        if(root!=null) {
            inorder(root.left);
            System.out.println(root.key);
            inorder(root.right);
        }
    }




    public static void main(String args[]){

        AAcBinarySearchTree tree= new AAcBinarySearchTree();
        tree.insert(10);
        tree.insert(5);
        tree.insert(4);
        tree.insert(20);
        tree.insert(30);


        tree.inorder(tree.root);


    }



}
