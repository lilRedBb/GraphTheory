import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author lilred
 * @date 2023/05/31
 **/

class Pair{
    int first;
    int second;

    public int getFirst(){
        return first;
    }

    public int getSecond() {
        return second;
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }
}


public class snakeAndladder {

    static class Graph{
        int V;
        ArrayList<Integer>[] list;

        public Graph(int v) {
            V = v;
            list = new ArrayList[v];
            for (int i=0;i<V;i++){
                list[i] = new ArrayList<>();
            }
        }

        void addEdge(int src,int des){
            list[src].add(des);
        }

        int minCostBFS(int src, int des){
            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[V];
            Arrays.fill(visited,false);
            int[] distance = new int[V];


            q.add(src);
            visited[src]=true;
            distance[src]=0;

            while (!q.isEmpty()){
                int head = q.poll();
                for (int nbr:list[head]){
                    if (!visited[nbr]){
                        q.add(nbr);
                        visited[nbr]=true;
                        distance[nbr] = distance[head]+1;
                    }
                }
            }
            return distance[des];
        }


    }

    public static int min_dice_throw(int n, ArrayList<Pair> snakes, ArrayList<Pair> ladder){
        int[] board = new int[n+1];


        for (Pair sp:snakes){
            int s = sp.getFirst();
            int e = sp.getSecond();
            board[s] = e-s;
        }

        for (Pair lp:ladder){
            int s = lp.getFirst();
            int e = lp.getSecond();
            board[s] = e-s;
        }

        Graph g = new Graph(n+1);
        for (int u=1;u<n;u++){
            for (int dice=1;dice<=6;dice++){
                int v=u+dice;
                v+= board[v];
                if (v<=n){
                    g.addEdge(u,v);
                }
            }
        }
        return g.minCostBFS(1,n);

    }

}
