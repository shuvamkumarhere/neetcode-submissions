class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < piles.length; i++){
            max = Math.max(piles[i], max);
        }
        int ans = -1;
        int left = 1, right = max;
        while(left <= right){
            int mid = left + (right - left) / 2;
            int hours = 0;
            for(int i = 0; i < piles.length; i++){
                hours += Math.ceil((double)piles[i] / mid);
            }
            if(hours <= h){
                right = mid - 1;
                ans = mid;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }
}
