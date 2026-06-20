class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, col = matrix[0].length;
        int left = 0, right = row * col - 1;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int currRow = mid / col, currCol = mid % col;
            if(matrix[currRow][currCol] == target){
                return true;
            } else if(target < matrix[currRow][currCol]){
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }
}
