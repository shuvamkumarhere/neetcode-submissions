class Solution {
    private boolean solve(char[][] board, String word, int i, int j, boolean [][] visited, int idx){
        if(word.length() == idx){
            return true;
        }
        boolean isPresent = false;
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j]) return false;
        if(board[i][j] == word.charAt(idx)){
            visited[i][j] = true;
            isPresent = solve(board, word, i + 1, j, visited, idx + 1) 
            || solve(board, word, i - 1, j, visited, idx + 1)
            || solve(board, word, i, j - 1, visited, idx + 1)
            || solve(board, word, i, j + 1, visited, idx + 1);
            visited[i][j] = false;
        }
        return isPresent;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean [][] visited = new boolean[n][m];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(solve(board, word, i, j, visited, 0)) return true;
            }
        }
        return false;
    }
}
