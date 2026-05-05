class Solution {
    private int[][] grid;
    private int r,c;
    private boolean[][] visited;
    private int maxArea;

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        r = grid.length;
        c = grid[0].length;
        visited = new boolean[r][c];
        maxArea = 0;

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j]==1) {
                    maxArea = Math.max(maxArea, traverse(i,j));
                }
            }
        }
        return maxArea;
    }

    public int traverse(int i, int j) {
        if(i<0 || j<0 || i>=r || j>=c || grid[i][j]==0) {
            return 0;
        }
        if(visited[i][j]) {
            return 0;
        }

        visited[i][j] = true;

        return  1+traverse(i-1,j)+traverse(i+1,j)+traverse(i,j-1)+traverse(i,j+1);
    }
}
