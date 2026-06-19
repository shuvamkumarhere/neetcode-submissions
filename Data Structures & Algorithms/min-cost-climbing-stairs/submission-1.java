class Solution {
    int[] memo = new int[1001];
    // private int solve(int[] cost, int step){
    //     if(step >= cost.length) return 0;
    //     if(memo[step] != -1) return memo[step];  
    //     memo[step] = cost[step] + Math.min(solve(cost, step + 1), solve(cost, step + 2));
    //     return memo[step];
    // }
    public int minCostClimbingStairs(int[] cost) {
        // Arrays.fill(memo, -1);
        // return Math.min(solve(cost, 0), solve(cost, 1));
        memo[0] = cost[0];
        memo[1] = cost[1];
        for(int i = 2; i < cost.length; i++){
            memo[i] = cost[i] + Math.min(memo[i - 1], memo[i - 2]);
        }
        return Math.min(memo[cost.length - 1], memo[cost.length - 2]);
    }
}