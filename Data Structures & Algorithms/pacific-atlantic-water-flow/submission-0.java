class Solution {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    private List<List<Integer>> res;
    private int[][] heights;
    private int r,c;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        res = new ArrayList<>();
        this.heights = heights;
        r = heights.length;
        c = heights[0].length;

        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if((i==0 && j==c-1) || (i==r-1 && j==0)){
                    res.add(Arrays.asList(i,j));
                }
                else {
                    bfs(i,j);
                }
            }
        }
        return res;
    }

    public void bfs(int i, int j){
        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[r][c];
        q.offer(new int[]{i,j});
        visited[i][j]=true;
        boolean atlantic = false;
        boolean pacific = false;

        while(!(atlantic && pacific) && !q.isEmpty()){
            int[] curr = q.poll();
            int currRow = curr[0];
            int currCol = curr[1];
            for(int[] dir : directions){
                int newRow = dir[0]+currRow;
                int newCol = dir[1]+currCol;

                if(newRow == -1 || newCol == -1){
                    pacific = true;
                }
                else if(newRow == r || newCol == c){
                    atlantic = true;
                }
                else if(!visited[newRow][newCol] && 
                heights[newRow][newCol]<=heights[currRow][currCol]){
                    visited[newRow][newCol] = true;
                    q.offer(new int[]{newRow, newCol});
                }
            }
        }
        if(atlantic && pacific){
            res.add(Arrays.asList(i,j));
        }
    }
}
