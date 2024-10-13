package LeetCode.Daily2.Graphs.medium;

import java.util.*;


public class AAA001_1334_FindCityWithSmallestNumberOfNeiighbors {



    /* my solution worked for 41/55 test cases
    * and this is based on print all paths
    * failed at test case 3
    * .*/

    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //create arraylist/adjaceny list representation of the graph
        // it is an array of ArrayList objects. (arraylist of neighbors)
        // where each object in the arraylist stores the int []
        // each element of int[] array has edge info.
        ArrayList<int[]>[] graph = new ArrayList[n];

        // initialise each array object
        for(int i=0;i<n;i++){
            graph[i] = new ArrayList();
        }

        // for each edge given add the nodes to the graph
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int distance = edge[2];
            graph[node1].add(new int[]{node2, distance});
            graph[node2].add(new int[]{node1, distance});
        }

        int minNeighbors = n;
        int res=0;


        // for each node check the number of neighbours it has and update minNeighbors
        for (int source = 0; source < n; source++) {
            boolean vis[] = new boolean[n];
            vis[source]=true;

            System.out.println("started the source "+source);
            int neighbors = getNumberOfNeighborsBelowThreshhold(graph, source, n, distanceThreshold,0,0,vis);
            System.out.println("neighbors are "+neighbors);
            if (neighbors <= minNeighbors) {
                minNeighbors = neighbors;
                res = source;
            }
            vis[source]=false;
        }
        return res;
    }


    private int getNumberOfNeighborsBelowThreshhold(ArrayList<int[]> graph[], int source, int n, int distanceThreshold,int distance,int count,boolean vis[]) {


        Set<Integer> visited = new HashSet<>();

        int currentNeighbor[];
        int currentDistance;
        for(int i=0;i<graph[source].size();i++){

            currentNeighbor = graph[source].get(i);
            //for each neighbor
            currentDistance = distance+currentNeighbor[1];
            if(currentDistance <= distanceThreshold && !vis[currentNeighbor[0]]){
                vis[currentNeighbor[0]] = true;
                /* increase the count only if the neighbour is not visited in any other path

                 */

                count = getNumberOfNeighborsBelowThreshhold(graph, currentNeighbor[0], n, distanceThreshold,currentDistance,count +1,vis);
            }
            //vis[currentNeighbor[0]] = false;
            System.out.println("count" + count + " source"+ source+"currentNeighbor"+currentNeighbor[0]);


        }
        return count;
    }






    /* this passed all and should read concept of priorityQueue to understand this

    class Solution {

     public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        //create arraylist/adjaceny list representation of the graph
        ArrayList<ArrayList<int[]>> graph = new ArrayList<>();
        // initialise each array object
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }

        // for each edge given add the nodes to the graph
        for (int[] edge : edges) {
            int node1 = edge[0];
            int node2 = edge[1];
            int distance = edge[2];
            graph.get(node1).add(new int[]{node2, distance});
            graph.get(node2).add(new int[]{node1, distance});
        }

        int minNeighbors = n;
        int result=0;

        // for each node check the number of neighbours it has and update minNeighbors
        for (int source = 0; source < n; source++) {
            int neighbors = getNumberOfNeighborsBelowThreshhold(graph, source, n, distanceThreshold);
            if (neighbors <= minNeighbors) {
                minNeighbors = neighbors;
                result = source;
            }
        }
        return result;
    }

    private int getNumberOfNeighborsBelowThreshhold(ArrayList<ArrayList<int[]>> graph, int source, int n, int distanceThreshold) {
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        minHeap.add(new int[]{0, source});
        Set<Integer> visited = new HashSet<>();

        while (!minHeap.isEmpty()) {
            int[] top = minHeap.poll();
            int distance_to_this_node = top[0], cur_node = top[1];
            if (!visited.contains(cur_node)) {
                visited.add(cur_node);
                for (int[] neighbor : graph.get(cur_node)) {
                    int distance_from_source = distance_to_this_node + neighbor[1];
                    if (distance_from_source <= distanceThreshold) { // ensure that we're allowed to go to this node
                        minHeap.add(new int[]{distance_from_source, neighbor[0]});
                    }
                }
            }
        }
        return visited.size() - 1;
        // we are doing -1 as we have added the node itself to list of visited nodes
    }


}
     */



    public static void main(String[] args) {
        int n=4;
        int[][] edges = new int[][]{{0,1,3},{1,2,1},{1,3,4},{2,3,1}};
        int distanceThreshold = 4;
        // expected 3
        AAA001_1334_FindCityWithSmallestNumberOfNeiighbors obj = new AAA001_1334_FindCityWithSmallestNumberOfNeiighbors();

        System.out.println(obj.findTheCity(n,edges,distanceThreshold));
        // expected is 3


        System.out.println("testcase -----------------------------------------------");

        /*
        n=6;
        edges = new int[][]{{0,3,7},{2,4,1},{0,1,5},{2,3,10},{1,3,6},{1,2,1}};
        distanceThreshold = 417;
        System.out.println(obj.findTheCity(n,edges,distanceThreshold));

         */

        System.out.println("testcase -----------------------------------------------");

        // test case 3
        n=6;
        edges = new int[][] {{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}};
        distanceThreshold = 20;
        System.out.println(obj.findTheCity(n,edges,distanceThreshold));
        // expected is 5
        // but the code is returning 3 as output.






    }
}