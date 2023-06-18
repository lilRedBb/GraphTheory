/**
 * @author lilred
 * @date 2023/05/29
 **/
import java.util.*;

public class GGraph {

    private int numOfV;
    private LinkedList<Integer>[] adjacencylist;

    public GGraph(int numOfV){
        this.numOfV = numOfV;
        adjacencylist = new LinkedList[numOfV];
        for(int i=0; i<numOfV;i++){
            adjacencylist[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src,int des,boolean direct){
        if(direct){
            adjacencylist[src].add(des);
        }else {
            adjacencylist[src].add(des);
            adjacencylist[des].add(src);
        }
    }

    public void bfs(int startV){
        boolean[] visited = new boolean[numOfV];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[startV] = true;
        queue.add(startV);
        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.println(current+"is current v");
            for(int i:adjacencylist[current]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }
    }

    public void dfs_helper(int node,boolean[] visited){
        visited[node] = true;
        System.out.println("current node is "+node);
        for(int i:adjacencylist[node]){
            if (!visited[i]){
                dfs_helper(i,visited);
            }
        }
        return;

    }

    public void dfs(int StartV){
        boolean[] visited = new boolean[numOfV];
        dfs_helper(StartV, visited);
    }


    public void bfs_short(int startV, int desV){
        boolean[] visited = new boolean[numOfV];
        LinkedList<Integer> queue = new LinkedList<>();
        int[] parent = new int[numOfV];
        int[] distance = new int[numOfV];

        for(int i=0;i<startV;i++){
            parent[i] = -1;
        }

        visited[startV] = true;
        queue.add(startV);

        parent[startV] = startV;
        distance[startV] = 0;

        while (!queue.isEmpty()){
            int current = queue.poll();
            System.out.println(current+"is current v");
            for(int i:adjacencylist[current]){
                if(!visited[i]){
                    visited[i] = true;
                    queue.add(i);
                    parent[i] = current;
                    distance[i] = distance[current]+1;
                }
            }
        }

        for(int i=0;i<numOfV;i++){
            System.out.println("shortest distance from"+startV+"to"+i+"is"+distance[i]);
        }

        System.out.println("shortest path from"+startV+"to"+desV+"is:");
        int temp = desV;
        while (temp!=startV){
            System.out.println(temp+"->");
            temp = parent[temp];
        }
        System.out.println(temp);
    }

    public static void main(String[] args) {
        int numVertices = 5;
        GGraph graph = new GGraph(numVertices);
        graph.addEdge(0, 1,true);
        graph.addEdge(0, 4,true);
        graph.addEdge(1, 2,true);
        graph.addEdge(1, 3,true);
        graph.addEdge(1, 4,true);
        graph.addEdge(2, 3,true);
        graph.addEdge(3, 4,true);

        graph.dfs(0);
    }

}
