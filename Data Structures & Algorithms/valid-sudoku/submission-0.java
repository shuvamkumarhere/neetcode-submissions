class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int row = 0; row < 9; row++){
            Set<Character> set = new HashSet<>();
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '.') continue;
                if(set.contains(board[row][col])) return false;
                else set.add(board[row][col]);
            }
        }
        for(int col = 0; col < 9; col++){
            Set<Character> set = new HashSet<>();
            for(int row = 0; row < 9; row++){
                if(board[row][col] == '.') continue;
                if(set.contains(board[row][col])) return false;
                else set.add(board[row][col]);
            }
        }
        for(int row = 0; row < 9; row += 3){
            for(int col = 0; col < 9; col += 3){
                int er = row + 2, ec = col + 2;
                if(!traverseAndCheck(board, row, col, er, ec)) return false;
            }
        }
        return true;
    }
    private boolean traverseAndCheck(char[][] board, int sr, int sc, int er, int ec){
        Set<Character> set = new HashSet<>();
        for(int row = sr; row < sr + 3; row++){
            for(int col = sc; col < sc + 3; col++){
                if(board[row][col] == '.') continue;
                if(set.contains(board[row][col])) return false;
                else set.add(board[row][col]);
            }
        }
        return true;
    }
}
