class Solution {
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        if(nums.length == 0) return 0;
        // if(nums.length == 1) return 1;
        int count = 1, maxCount = Integer.MIN_VALUE, last = nums[0];
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == last + 1){
                count++;
                last = nums[i];
            } else if(nums[i] == last){
                continue;
            } else {
                count = 1;
                last = nums[i];
            }
            if(maxCount < count) maxCount = count;
        }
        return Math.max(maxCount, count);
    }
}
