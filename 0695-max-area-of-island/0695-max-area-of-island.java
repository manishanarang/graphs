class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        
    int m = grid.length;
        int n = grid[0].length;

        boolean visited[][] = new boolean[m][n];
        
        int maxArea = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    int area = dfs(grid, i, j, m,n, visited);
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
    public int dfs(int[][] grid, int i, int j, int m, int n, boolean[][] visited){
        if(grid[i][j] == 1 && !visited[i][j]){
        int area = 1;
        visited[i][j] = true;
        
        if(i+1<m) area+=dfs(grid, i+1, j, m,n,visited);
        if(j+1 < n) area+=dfs(grid, i, j+1, m,n,visited);
        if((i-1)>=0 ) area+=dfs(grid, i-1, j, m,n,visited);
        if((j-1)>=0) area+=dfs(grid, i, j-1, m,n,visited);
        return area;
        }
        return 0;
    }
}