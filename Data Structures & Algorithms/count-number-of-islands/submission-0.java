class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = 0;
        boolean visited[][] = new boolean[n][m];
        for( int i=0 ; i< n ; i++) {
            for(int j = 0 ; j < m ;j++) {
                if(grid[i][j] == '1' && !visited[i][j]) {
                    result += 1;
                    dfs(i, j , grid, visited);
                }
            }
        }
        return result;
    }

    void dfs(int i, int j, char[][] grid, boolean[][] visited) {
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0' || visited[i][j]) return ;
        int[][] moves = new int[][] {
            {-1,0},
            {0,-1},
            {0,1},
            {1,0}
        };
        visited[i][j] = true;
        for(int index=0;index<4;index++) {
            dfs(i + moves[index][0], j + moves[index][1], grid, visited);
        }
    }

}
