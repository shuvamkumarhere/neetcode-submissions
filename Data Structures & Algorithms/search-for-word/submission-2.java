class Solution {
    private boolean solve(char[][] board, String word, int i, int j, int idx){
        if(word.length() == idx){
            return true;
        }
        boolean isPresent = false;
        
        if(i < 0 || i >= board.length 
        || j < 0 || j >= board[0].length 
        || board[i][j] != word.charAt(idx)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        isPresent = solve(board, word, i + 1, j, idx + 1) 
        || solve(board, word, i - 1, j, idx + 1)
        || solve(board, word, i, j - 1, idx + 1)
        || solve(board, word, i, j + 1, idx + 1);
        board[i][j] = temp;
        return isPresent;
    }
    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(solve(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
}
