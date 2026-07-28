class Solution {
    private List<String> construct(char[][] board){
        List<String> res = new ArrayList<>();
        for(int i = 0; i < board.length; i++){
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < board.length; j++){
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }
    private boolean isSafe(char[][] board, int row, int col){
        int n = board.length;
        for(int i = row - 1; i >= 0; i--){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        // for(int i = col - 1; i >= 0; i--){
        //     if(board[row][i] == 'Q'){
        //         return false;
        //     }
        // }
        // for(int i = col + 1; i < n; i++){
        //     if(board[row][i] == 'Q'){
        //         return false;
        //     }
        // }
        for(int i = row - 1, j = col - 1; i >= 0 && j>= 0; i--, j--){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        for(int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++){
            if(board[i][j] == 'Q'){
                return false;
            }
        }
        return true;
    }
    private void solve(char[][] board, List<List<String>> result, int row){
        if(row == board.length){
            result.add(construct(board));
            return;
        }
        for(int i = 0; i < board.length; i++){
            if(isSafe(board, row, i)){
                board[row][i] = 'Q';
                solve(board, result, row + 1);
                board[row][i] = '.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(board[i], '.');
        }
        solve(board, result, 0);
        return result;
    }
}
