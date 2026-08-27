class Solution {
    private int maxArea = 0;
    public int dfs(int[][] grid, boolean[][] visited, int i, int j){
        visited[i][j] = true;
        int left = 0;
        if(i > 0 && grid[i - 1][j] == 1 && visited[i - 1][j] == false){
            left = dfs(grid, visited, i - 1, j);
        }
        int up = 0;
        if(j > 0 && grid[i][j - 1] == 1 && visited[i][j - 1] == false){
            up = dfs(grid, visited, i, j - 1);
        }
        int right = 0;
        if(i < grid.length - 1 && grid[i + 1][j] == 1 && visited[i + 1][j] == false){
            right = dfs(grid, visited, i + 1, j);
        }
        int down = 0;
        if(j < grid[0].length - 1 && grid[i][j + 1] == 1 && visited[i][j + 1] == false){
            down = dfs(grid, visited, i, j + 1);
        }
        return up + down + left + right + 1;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid[0].length;
        int m = grid.length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    maxArea = Math.max(dfs(grid, visited, i, j), maxArea);
                }
            }
        }
        return maxArea;
    }
}
