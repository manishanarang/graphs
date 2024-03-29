class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i = 0; i <m ; i++){
                for(int j = 0 ; j < n; j++){
                    if((i == 0 || j == 0 || i == (m-1) || j == (n-1)) && board[i][j] == 'O'){
                        dfs(i,j, board, m,n);
                    }
                }
            }

            for(int i = 0; i <m ; i++){
                for(int j = 0 ; j < n; j++){
                    if( board[i][j] == 'O'){
                        board[i][j] = 'X';
                    }
                }
            }
            
            for(int i = 0; i <m ; i++){
                for(int j = 0 ; j < n; j++){
                    if(board[i][j] == 'P'){
                        board[i][j] = 'O';
                    }
                }
            }
    }

        public void dfs(int i, int j, char[][]board, int m, int n){
            if(board[i][j] == 'O'){
                board[i][j] = 'P';
                if(i+1 < m) dfs(i+1,j, board, m,n);
                if(j+1 < n) dfs(i,j+1, board, m,n);
                if(i > 0 ) dfs(i-1,j, board, m,n);
                if(j > 0) dfs(i,j-1, board, m,n);
        }
        }
}
    
