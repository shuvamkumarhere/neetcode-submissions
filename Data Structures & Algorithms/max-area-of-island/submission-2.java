class Solution {
    public int dfs(int[][] grid, boolean[][] visited, int i, int j){
        visited[i][j] = true;
        int area = 1;
        if(i + 1 < grid.length && grid[i + 1][j] == 1 && !visited[i + 1][j]){
            area += dfs(grid, visited, i + 1, j);
        }
        if(j + 1 < grid[0].length && grid[i][j + 1] == 1 && !visited[i][j + 1]){
            area += dfs(grid, visited, i, j + 1);
        }
        if(i - 1 >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]){
            area += dfs(grid, visited, i - 1, j);
        }
        if(j - 1 >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]){
            area += dfs(grid, visited, i, j - 1);
        }
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length, m = grid[0].length, maxArea = 0;
        boolean[][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == 1){
                    int area = dfs(grid, visited, i, j);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;
    }
}
   