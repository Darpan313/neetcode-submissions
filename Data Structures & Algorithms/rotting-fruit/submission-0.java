class Solution {
    public int orangesRotting(int[][] grid) {
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        Queue<int[]> rottenIndex = new LinkedList<>();
        int r = grid.length;
        int c = grid[0].length;
        int fresh = 0;
        int time = 0;

        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j]==1) {
                    fresh++;
                }
                if(grid[i][j]==2){
                    rottenIndex.offer(new int[]{i,j});
                }
            }
        }
        
        while(fresh>0 && !rottenIndex.isEmpty()){
            int size = rottenIndex.size();
            for(int k=0; k<size; k++) {
                int[] curr = rottenIndex.poll();

                for(int[] dir:directions) {
                    int nr = curr[0]+dir[0];
                    int nc = curr[1]+dir[1];

                    if(nr>=0 && nc>=0 && nr<r && nc<c && 
                    grid[nr][nc]==1) {
                        grid[nr][nc] = 2;
                        rottenIndex.offer(new int[]{nr,nc});
                        fresh--;
                    }
                }
            }
            time++;
        }
        return fresh == 0? time : -1;
    }
}
