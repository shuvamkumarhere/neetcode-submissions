class Solution {
    public int trap(int[] height) {        
        int n = height.length;
        int left = 0, right = n - 1, leftMax = height[0], rightMax = height[n - 1], totalWater = 0;
        while(left < right){
            if(height[left] < height[right]){
                leftMax = Math.max(height[left], leftMax);
                int water = leftMax - height[left];
                totalWater += water > 0 ? water : 0;
                left++;
            } else {
                rightMax = Math.max(height[right], rightMax);
                int water = rightMax - height[right];
                totalWater += water > 0 ? water : 0;
                right--;
            }
        }
        return totalWater;
    }
}
