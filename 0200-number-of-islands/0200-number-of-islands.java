class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m == 0)
        return 0;

        boolean visited[][] = new boolean[m][n];
        for(boolean[] row : visited ){
            Arrays.fill(row, false);
        }
        
        int count = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    count++;
                    dfs(grid, i, j, m,n, visited);
                }
            }
        }
        return count;
    }

    public void dfs(char[][] grid, int i, int j, int m, int n, boolean[][] visited){
        if(grid[i][j] == '1' && !visited[i][j]){
        visited[i][j] = true;

        if(i+1<m && j < n) dfs(grid, i+1, j, m,n,visited);
        if(i<m && j+1 < n) dfs(grid, i, j+1, m,n,visited);
        if(i-1>=0 && j < n) dfs(grid, i-1, j, m,n,visited);
        if(i<m && j-1>=0) dfs(grid, i, j-1, m,n,visited);
        }
    }
}