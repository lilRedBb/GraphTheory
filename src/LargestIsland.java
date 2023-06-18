/**
 * @author lilred
 * @date 2023/06/10
 **/


public class LargestIsland {

    public int dfs(int[][]grid, int i, int j, int m, int n, boolean[][]visited ){

        if (i<0||i>=m||j<0||j>=n||visited[i][j]||grid[i][j]==0){
            return 0;
        }
        visited[i][j] = true;
        return 1+dfs(grid,i+1,j,m,n,visited)+dfs(grid,i-1,j,m,n,visited)+dfs(grid,i,j+1,m,n,visited)+dfs(grid,i,j-1,m,n,visited);

    }

    public int largest_isdland(int[][] grid){
        int max = 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i=0;i<m;i++){
            for (int j=0;j<n;j++){
                if (!visited[i][j]){
                    int size = dfs(grid,i,j,m,n,visited);
                    max = Math.max(size,max);
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {

        LargestIsland lg = new LargestIsland();
        int[][] grid = {{1,1,0,0,0},
                {1,1,0,0,0},
                {0,1,1,1,1},
                {0,0,0,1,1}};

        System.out.println(lg.largest_isdland(grid));

    }
}
