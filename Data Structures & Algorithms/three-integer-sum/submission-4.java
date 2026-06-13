class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1, right = nums.length - 1;
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            while (left < right) {
                if (nums[left] + nums[right] + nums[i] > 0) {
                    right--;
                } else if (nums[left] + nums[right] + nums[i] < 0) {
                    left++;
                } else {
                    result.add(Arrays.asList(nums[left], nums[i], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1] ) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
//-4, -1, -1, 0, 1, 2
