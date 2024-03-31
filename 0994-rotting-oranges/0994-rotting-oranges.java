class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int dir_x[] = new int[]{1, -1, 0,0};
        int dir_y[] = new int[]{0, 0, 1,-1};
        int time =0, freshOranges = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i = 0; i<m; i++){
            for(int j = 0; j <n; j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                }
                if(grid[i][j] == 2){
                    queue.add(new int[]{i,j});
                }
            }
        }
        

        while(!queue.isEmpty() && freshOranges > 0){
            int sz = queue.size();
            for(int l = 0; l < sz; l++){
                        int[] rotten = queue.remove();
                        int row = rotten[0];
                        int col = rotten[1];

                        for(int k = 0; k < 4; k++){
                            int new_row = row + dir_x[k];
                            int new_col = col + dir_y[k];
                        if(isValid(new_row, new_col, m,n) && grid[new_row][new_col]==1 ){
                            freshOranges--;
                            grid[new_row][new_col] = 2;
                            queue.add(new int[]{new_row,new_col});
                        }
                        }
                    }
                    time++;
        }
    

    
            if(freshOranges == 0){
                return time;
            }
        
        return -1;
    }

    public boolean isValid(int i, int j, int m, int n){
        return (i<m && j <n && i >= 0 && j >= 0);
    }
}