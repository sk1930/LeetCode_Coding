package LeetCode.Daily2.Graphs.medium;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;


public class AAA001_1334_FindCityWithSmallestNumberOfNeiighbors2 {



    /* my solution worked for 41/55 test cases
    * and this is based on print all paths.
    *
    * and somehave going into a long loop...becoz of visited[source] = false....*/

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
//        for (int source = 3; source < 4; source++) {

            boolean vis[] = new boolean[n];
            vis[source]=true;
            Set<Integer> visCounted = new HashSet<>();

            visCounted.add(source);
            System.out.println("started the source "+source);
            int neighbors = getNumberOfNeighborsBelowThreshhold(graph, source, n, distanceThreshold,0,0,vis,visCounted);
            System.out.println("neighbors are "+neighbors);
            if (neighbors <= minNeighbors) {
                minNeighbors = neighbors;
                res = source;
            }
            vis[source]=false;
        }
        return res;
    }


    private int getNumberOfNeighborsBelowThreshhold(ArrayList<int[]> graph[], int source, int n, int distanceThreshold,int distance,int count,boolean vis[],Set<Integer> visCounted) {



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
                if(!visCounted.contains(currentNeighbor[0])){
                    count = count+1;
                    visCounted.add(currentNeighbor[0]);
                }
                if(count == n){
                    return count;
                }

                count = getNumberOfNeighborsBelowThreshhold(graph, currentNeighbor[0], n, distanceThreshold,currentDistance,count,vis,visCounted);
            }
            vis[currentNeighbor[0]] = false;
            // the neighbor should be set back to false so that
            // it should be visited in another path , but it should not be counted.

            //System.out.println("count" + count + " source"+ source+"currentNeighbor"+currentNeighbor[0]);


        }
        //return visCounted.size()-1;
        return count;
    }







    public static void main(String[] args) {



        /*
             3
        0 -------- 1
                  |  \
                 4|   \ 1
                  |    \
        4 ------- 2-----3
             1        1

             if u dont set visited to false after call is returned
             when source 1 and it reached 2 it sets the visited[2] to true, and in that path it can reach 2 so count is 1
             now when it goes in 1--3---2--5
             there are 3 neighbors actually 3,2,5,
            but if visited[2] is not set back to false , it will stop at 2 and cannot go to 5.
            // so better set it back to false but not count it as a new neighbor....by maintaining another set of counted neighbors of a node.

         */



        int n=5;
        int[][] edges = new int[][]{{0,1,3},{1,2,4},{1,3,1},{2,3,1},{2,4,1}};
        int distanceThreshold = 4;
        // expected 3
        AAA001_1334_FindCityWithSmallestNumberOfNeiighbors2 obj = new AAA001_1334_FindCityWithSmallestNumberOfNeiighbors2();

        //System.out.println(obj.findTheCity(n,edges,distanceThreshold));
        // expected is 0
        // above solution is working but timing out for below case

        System.out.println("testcase -----------------------------------------------");

        // test case 3
        n=6;
        edges = new int[][] {{0,1,10},{0,2,1},{2,3,1},{1,3,1},{1,4,1},{4,5,10}};
        distanceThreshold = 20;
        System.out.println(obj.findTheCity(n,edges,distanceThreshold));
        // expected is 5
        // by setting visited to false it will go in to other route also and count correct.
        // but it it getting time limit exceeded on
        /*
        n =
6
edges =
[[0,3,7],[2,4,1],[0,1,5],[2,3,10],[1,3,6],[1,2,1]]
distanceThreshold =
417

        So there should be a way to stop iterating when the count reached is equal to number of nodes -1

        but even after adding count condition it is failiing with time limit exceeded so better to try other ways
        by learning more graph traversal algos.*/





    }
}