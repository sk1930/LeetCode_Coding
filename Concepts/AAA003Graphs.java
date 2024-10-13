package Concepts;
import java.util.*;

public class AAA003Graphs {


    static class Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s, int d, int w) {
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
    }
    static void createGraph(ArrayList<Edge> graph[]) {
        // initialise each node with an arraylist object to store the edge details
        //create arraylist/adjaceny list representation of the graph
        // it is an array of ArrayList objects.
        // where each arraylist object is an arraylist of edges.
        for(int i=0; i<graph.length; i++) {
            graph[i] = new ArrayList<>();
        }
        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));
        graph[2].add(new Edge(2, 0, 1));

        graph[2].add(new Edge(2, 4, 1));
        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 4, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));
        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));
        graph[5].add(new Edge(6, 5, 1));
    }
    public static void bfs(ArrayList<Edge> graph[], int V) {
        boolean visited[] = new boolean[V];
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(0); //Source = 0
        while(!q.isEmpty()) {
            // at each node see if it is already visited
            // if not visited add the neighbors to the queue
            // print
            /// mark it as visited
            int curr = q.remove();
            if(!visited[curr]) {
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void disconnectedBFS(ArrayList<Edge>[] graph, int V, boolean[] visited) {
        Queue<Integer> q = new ArrayDeque<Integer>();
        q.add(0); //Source = 0
        while(!q.isEmpty()) {
            // at each node see if it is already visited
            // if not visited add the neighbors to the queue
            // print
            /// mark it as visited
            int curr = q.remove();
            if(!visited[curr]) {
                System.out.print(curr+" ");
                visited[curr] = true;
                for(int i=0; i<graph[curr].size(); i++) {
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);
                }
            }
        }
        System.out.println();
    }

    public static void dfs(ArrayList<Edge> graph[], int curr, boolean visited[]) {
        // bfs is like queue and dfs is like stack
        // as soon a node is present ,loop for its neighbours
        // and call dfs on each neighbor
        System.out.print(curr+" ");
        visited[curr] = true;
        for(int i=0; i<graph[curr].size(); i++) {
            //loop on the neighbors
            Edge e = graph[curr].get(i);
            if(!visited[e.dest])
                dfs(graph, e.dest, visited);
        }

    }

    public static void printAllPaths(ArrayList<Edge> graph[], int src, int tar, String
            path, boolean vis[]) {
        if(src == tar) {
            System.out.println(path);
            return;
        }
        for(int i=0; i<graph[src].size(); i++) {
            Edge e = graph[src].get(i);
            if(!vis[e.dest]) {
                vis[e.dest] = true;
                printAllPaths(graph, e.dest, tar, path+"->"+e.dest, vis);
                vis[e.dest] = false;
            }
        }
        /* Strings are immutable and here we are passing a string object to the child function but in the subsequent call
        when the string object is modified it is a different object overall
        and when the call returns to the caller/parent ,
        the string object with the caller is not linked to the object in the called function becoz both are different objects.
        and the string object has the same value before and after the call in the parent function.

        so after visiting 2
        printpaths(graph,2,5,0+1+3+4+2,visited)
        the neighbors of are already visited
        and call is returned back to printpaths(graph,4,5,0+1+3+4,vis)
        the original string object is same it didnt change.(0+1+1+3+4).
         */

        // we are making visited = false after the call is returned becoz,
        // in the same path as the subsequent calls are made, the same node should not be visited again ,
        // but in a different path it can be visited again thats the reason we make visited as false after the control is returned.
    }


    public static void main(String args[]) {

        /*
        1 --- 3
        /      |  \
        0      |    5 -- 6
        \      |  /
        2 ---- 4
        */
        int V = 7;
        ArrayList<Edge> graph[] = new ArrayList[V];
        /* if i create as below am getting an error
        ArrayList<Edge> graph[] = new ArrayList<Edge>[V];
        java: generic array creation*/
        createGraph(graph);
        bfs(graph, V);

        // if the graph is disconnected
        // u have to call bfs on each disconnected graph part
        // so initialise the visited in this code and call the dfs code
        // on each unvisited node

        // first time disconnectedBFS is called on 0 th node and
        // if there is a 2nd subgraph separete with just 6 to 7 edges
        // then the disconnectedBFS is called again on the 6th node.
        boolean visited[] = new boolean[V];
        for(int i=0;i<V;i++) {
            if(visited[i]!=true)
                disconnectedBFS(graph, V, visited);
        }

        dfs(graph, 0, new boolean[V]);
        // above is for dfs if the graph is connected.
        System.out.println();

        // in case of disconnected graph

        visited = new boolean[V];
        for(int i=0;i<V;i++) {
            if(visited[i]!=true)
                dfs(graph, 0, visited);
        }
        System.out.println();



        int src = 0;
        int tar = 5;
        boolean vis[] = new boolean[V];
        vis[src] = true;
        printAllPaths(graph, src, tar, ""+src, vis);

    }

}