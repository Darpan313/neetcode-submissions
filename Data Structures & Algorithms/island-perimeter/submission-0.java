class Solution {
    private int[][] grid;
    private boolean[][] visited;
    private int r,c;

    public int islandPerimeter(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        visited = new boolean[r][c];
        this.grid = grid;

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++){
                if(grid[i][j]==1){
                    return dfs(i,j);
                }
            }
        }
        return 0;
    }

    public int dfs(int i, int j) {
        if(i<0 || j<0 || i>=r || j>=c || grid[i][j]==0) {
            return 1;
        }

        if(visited[i][j]==true) {
            return 0;
        }
        visited[i][j] = true;
        return dfs(i,j-1)+dfs(i-1,j)+dfs(i,j+1)+dfs(i+1,j);
    }
}