class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]> q = new LinkedList<int[]>();
        int n = grid.length, m = grid[0].length;
        int fresh = 0, rotten = 0;
        int moves[][] = new int[][] {
            {-1,0},
            {0,1},
            {0,-1},
            {1,0}
        };
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 2) {
                    q.add(new int[]{i,j});
                    rotten++;
                } else if(grid[i][j] == 1) {
                    fresh++;
                }
            }
        }
        if (fresh == 0) return 0;
        int minute = 0;
        
        while(!q.isEmpty() && fresh > 0) {
            int size = q.size();
            while(size-- > 0) {
                int[] currCell = q.poll();
                for(int[] move: moves) {
                    int newCellRow = currCell[0] + move[0];
                    int newCellCol = currCell[1] + move[1];
                    if(newCellRow >= 0 && newCellCol >= 0 && 
                    newCellRow< n && newCellCol < m && grid[newCellRow][newCellCol] == 1) {
                        fresh--;
                        grid[newCellRow][newCellCol] = 2;
                        q.add(new int[] {newCellRow, newCellCol});
                    }
                }
            }
            minute++;
        }
        if(fresh == 0){
            return minute;
        } else { 
            return -1;
        }
    }
}
