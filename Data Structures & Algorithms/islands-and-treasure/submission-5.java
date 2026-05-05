class Solution {
    private int[][] directions = {{1,0}, {-1,0},
                                  {0,1}, {0,-1}};
    private int[][] grid;
    private int r,c;
    public void islandsAndTreasure(int[][] grid) {
        this.grid = grid;
        r = grid.length;
        c = grid[0].length;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++){
                if(grid[i][j] == Integer.MAX_VALUE) {
                    grid[i][j] = bfs(i,j);
                }
            }
        }
    }

    public int bfs(int i, int j) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{i,j});
        boolean[][] visited = new boolean[r][c];
        visited[i][j] = true;
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            for(int k=0; k<size; k++) {
                int[] curr = q.poll();
                int row = curr[0];
                int col = curr[1];
                if(grid[row][col]==0){
                    return steps;
                }
                for(int[] dir:directions){
                    int newRow = row+dir[0], newCol = col+dir[1];
                    if(newRow>=0 && newCol>=0 && newRow<r && newCol<c &&
                    grid[newRow][newCol]!=-1 && !visited[newRow][newCol]) {
                        visited[newRow][newCol] = true;
                        q.add(new int[]{newRow, newCol});
                    }
                }
            }
            steps++;
        }
        return Integer.MAX_VALUE;
    }
}
