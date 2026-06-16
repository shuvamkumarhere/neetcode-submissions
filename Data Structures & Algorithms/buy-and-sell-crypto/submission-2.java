class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length, profit = 0, maxProfit = 0;
        int low = prices[0], high = prices[0];
        for(int i = 1; i < n; i++){
            if(low > prices[i]){
                    low = prices[i];
            }
            high = prices[i];
            profit = high - low;
            maxProfit = Math.max(profit, maxProfit);
        }
        return maxProfit;
    }
}
