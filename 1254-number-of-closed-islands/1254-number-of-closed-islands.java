class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(m == 0)
        return 0;
        
        int count = 0;

        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(i == 0 || j == 0 || i==(m-1) || j == (n-1)){
                    if(grid[i][j]==0){
                    dfs(grid, i, j, m,n);
                }
            }       
        }
        }
            
            for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                    if(grid[i][j]==0){
                        count++;
                    dfs(grid, i, j, m,n);
                }
            } 
    }
    return count;
}

    public void dfs(int [][] grid, int i, int j, int m, int n){
        if(grid[i][j] == 0){
            grid[i][j] = 1;

        if(i+1<m) dfs(grid, i+1, j, m,n);
        if(j+1 < n) dfs(grid, i, j+1, m,n);
        if(i-1>=0 ) dfs(grid, i-1, j, m,n);
        if(j-1>=0) dfs(grid, i, j-1, m,n);
        }
    }
}