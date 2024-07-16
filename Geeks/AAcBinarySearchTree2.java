package Geeks;

public class AAcBinarySearchTree2 {


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
    AAcBinarySearchTree2(){root = null;}


    public Node insert(Node root, int item){

        if (root==null){
            root = new Node(item);

            return root;
        }
        else if (item <= root.key){
            // we r updating root.left and root.right but not actual root

            root.left = insert(root.left,item);

        }
        else if (item > root.key){
            root.right = insert(root.right,item);

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

        AAcBinarySearchTree2 tree= new AAcBinarySearchTree2();
        tree.root = tree.insert(tree.root,10);
        // updating tree.root only once
        tree.insert(tree.root,5);
        tree.insert(tree.root,4);
        tree.insert(tree.root,20);
        tree.insert(tree.root,30);


        tree.inorder(tree.root);


    }
}
