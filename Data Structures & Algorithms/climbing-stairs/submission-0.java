class Solution {
    int[] memo = new int[46];
    private int solve(int n){
        if(n == 0) return 1;
        if(n < 0) return 0;
        if(memo[n] != -1) return memo[n];
        int left = solve(n - 1);
        int right = solve(n - 2);
        memo[n] = left + right;
        return memo[n];
    }
    public int climbStairs(int n) {
        for(int i = 0; i < 46; i++){
            memo[i] = -1;
        }
        return solve(n);
    }
}