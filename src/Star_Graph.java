/**
 * @author lilred
 * @date 2023/05/27
 **/
import java.util.*;

public class Star_Graph {

    public static int find_center(int[][] edges){
        Map<Integer,Integer> node_degree = new HashMap<>();

        for(int[] edge:edges){
            int u = edge[0];
            int v = edge[1];

            node_degree.put(u, node_degree.getOrDefault(u,0)+1);
            node_degree.put(v, node_degree.getOrDefault(v,0)+1);
        }

        int center = -1;

        for (int node: node_degree.keySet()){
            if (node_degree.get(node)==edges.length){
                center = node;
                break;
            }
        }
        return center;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2}, {2, 3}, {4, 2}};
        int res = Star_Graph.find_center(edges);
        System.out.println(res);

    }
}
