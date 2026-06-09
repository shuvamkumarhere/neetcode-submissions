class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for(int row = 0; row < 9; row++){
            for(int col = 0; col < 9; col++){
                if(board[row][col] == '.') continue;
                String rowStr = "ROW_" + String.valueOf(board[row][col]) + "_" + String.valueOf(row);
                String colStr = "COL_" + String.valueOf(board[row][col]) + "_" + String.valueOf(col);
                String boxStr = "BOX_" + String.valueOf(board[row][col]) + "_" + String.valueOf(row / 3) + "_" + String.valueOf(col/3);
                if(set.contains(rowStr) || set.contains(colStr) || set.contains(boxStr)) return false;
                set.add(rowStr);
                set.add(colStr);
                set.add(boxStr);
            }
        }
        return true;
    }
}
