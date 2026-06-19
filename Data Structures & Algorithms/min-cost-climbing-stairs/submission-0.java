class Solution {
    int[] memo = new int[1001];
    private int solve(int[] cost, int step){
        if(step >= cost.length) return 0;
        if(memo[step] != -1) return memo[step];  
        memo[step] = cost[step] + Math.min(solve(cost, step + 1), solve(cost, step + 2));
        return memo[step];
    }
    public int minCostClimbingStairs(int[] cost) {
        Arrays.fill(memo, -1);
        return Math.min(solve(cost, 0), solve(cost, 1));
    }
}