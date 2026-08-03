class Solution {
    private void dfs(boolean [][] visited, char[][] grid, int i, int j){
        visited[i][j] = true;
        if(j + 1 < grid[0].length && !visited[i][j + 1] && grid[i][j + 1] == '1'){
            dfs(visited, grid, i, j + 1);
        }
        if(i + 1< grid.length && !visited[i + 1][j] && grid[i + 1][j] == '1'){
            dfs(visited, grid, i + 1, j);
        }
        if(i - 1 >= 0 && !visited[i - 1][j] && grid[i - 1][j] == '1'){
            dfs(visited, grid, i - 1, j);
        }
        if(j - 1 >= 0 && !visited[i][j - 1] && grid[i][j - 1] == '1'){
            dfs(visited, grid, i, j - 1);
        }
        return;
    }
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        boolean [][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(visited, grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
}
