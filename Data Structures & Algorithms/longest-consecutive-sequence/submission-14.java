class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        int maxCount = Integer.MIN_VALUE, count = 1;
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        for(int i = 0; i < nums.length; i++){
            int ele = nums[i];
            if(!set.contains(ele - 1)){
                count = 1;
                while(set.contains(ele + 1)){
                    count++;
                    ele = ele + 1;
                }
            } else {
                count = 1;
            }
            maxCount = Math.max(maxCount, count);
        }
        return Math.max(maxCount, count);
    }
}
