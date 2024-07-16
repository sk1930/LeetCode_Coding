package LeetCode.Set.Medium;

import com.sun.source.tree.Tree;

import java.util.*;




public class AAA001_2196_CreateBinaryTreeFromDescriptions {
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

    static TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer, TreeNode> hashmaps = new HashMap<>();
        Set<Integer> childSet = new HashSet<>();
        //by end, parentSet will only have one node.
        TreeNode parentNode,childNode;
        /* everytime a node is created add it to map so that if the nodes appear like
        {50,80,0},{80,19,1}
        then when iterator is on 2nd ie [80,19,1]
        we have a reference of the object which is already created when iterator is on 1st ie [50,80,1]
         */
        for(int[] array:descriptions) {
            if (hashmaps.containsKey(array[0])) {
                parentNode = hashmaps.get(array[0]);
            } else {
                parentNode = new TreeNode(array[0]);
                hashmaps.put(array[0],parentNode);
            }
            if (hashmaps.containsKey(array[1])) {
                childNode = hashmaps.get(array[1]);
            } else {
                childNode = new TreeNode(array[1]);
                hashmaps.put(array[1],childNode);
            }
            if (array[2] == 1) {
                parentNode.left = childNode;
            } else {
                parentNode.right = childNode;
            }
            childSet.add(array[1]);
        }
        TreeNode root = null;
        for(int[] array:descriptions) {
            if(!childSet.contains(array[0])){
                root=hashmaps.get(array[0]);
            }
        }
        childSet.stream().forEach(System.out::println);

        
        /*
        Iterator<Integer> iterator = hashmaps.keySet().iterator();
        while (iterator.hasNext()) {
            Integer key = iterator.next();
        }
        
         */

        return root;


    }



    public static void main(String[] args) {
        int arr [][] = new int[][] {{20,15,1},{20,17,0},{50,20,1},{50,80,0},{80,19,1}};

        System.out.println(createBinaryTree(arr));

    }
}