class Solution {
    int[] memo = new int[46];
    public int climbStairs(int n) {
        memo[0] = 0;
        memo[1] = 1;
        memo[2] = 2;
        for(int i = 3; i <= n; i++){
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }
}