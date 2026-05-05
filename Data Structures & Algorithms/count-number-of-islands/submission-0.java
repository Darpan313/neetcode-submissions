class Solution {
    private boolean[][] visited;
    private char[][] grid;
    int r,c;
    int islands = 0;

    public int numIslands(char[][] grid) {
        r = grid.length;
        c = grid[0].length;
        this.grid = grid;
        visited = new boolean[r][c];

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++) {
                if(grid[i][j]== '1' && !visited[i][j]) {
                    traverse(i,j);
                    islands++;
                }
            }
        }
        return islands;
    }

    public void traverse(int i, int j) {
        if(i<0 || j<0 || i>=r || j>=c || grid[i][j]=='0') {
            return;
        }
        if(visited[i][j]) {
            return;
        }
        visited[i][j] = true;

        traverse(i,j-1);
        traverse(i,j+1);
        traverse(i-1,j);
        traverse(i+1,j);
    }
}
