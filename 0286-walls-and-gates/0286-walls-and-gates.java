class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;

        int[] dir_x = new int[]{1,-1,0,0};
        int[] dir_y = new int[]{0,0,1,-1};

        Queue<List<Integer>> queue = new LinkedList<>();
        boolean visited[][] = new boolean[m][n];

        for(int i = 0; i <m ; i++){
            for(int j = 0; j <n; j++){
                if(rooms[i][j] == 0) {
                    queue.add(List.of(i,j));
                    visited[i][j] = true;
                }
            }
        }


        while(!queue.isEmpty()){
            int sz = queue.size();
            for(int i = 0; i <sz;i++){
                List<Integer> li = queue.poll();
                int row = li.get(0);
                int col = li.get(1);

                for(int k = 0; k <4; k++){
                    int new_row = row + dir_x[k];
                    int new_col = col + dir_y[k];

                    if(isValid(new_row, new_col, m, n, visited, rooms)){
                        rooms[new_row][new_col] = rooms[row][col] + 1;
                        queue.add(List.of(new_row, new_col));
                        visited[new_row][new_col] = true;
                    }
                }
                
            }
        }
    }

    public boolean isValid(int r, int c, int m,int n, boolean[][] visited, int[][] rooms){
        return (r<m && c<n && r>=0 && c>=0 && 
        visited[r][c] == false && rooms[r][c]== 2147483647);
    }
}