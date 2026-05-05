class Solution {
    public void solve(char[][] board) {
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};
        int r = board.length;
        int c = board[0].length;

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j]=='O' &&(i==0 || j==0 || i==r-1 || j==c-1)){
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;
                }
            }
        }

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int currentRow = curr[0];
            int currentCol = curr[1];
            for(int[] dir : directions){
                int nr = currentRow+dir[0];
                int nc = currentCol+dir[1];

                if(nr>=0 && nc>=0 && nr<r && nc<c && board[nr][nc]=='O' && !visited[nr][nc]){
                    q.offer(new int[]{nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(board[i][j] == 'O' && !visited[i][j]){
                    board[i][j] = 'X';
                }
            }
        }
    }
}