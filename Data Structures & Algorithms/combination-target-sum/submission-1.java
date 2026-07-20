class Solution {
    private void solve(int[] nums, int target, List<Integer> temp, List<List<Integer>> result, int idx){
        if(0 == target){
            result.add(new ArrayList<>(temp));
            return;
        }
        if(idx == nums.length || target < 0) return;
        temp.add(nums[idx]);
        solve(nums, target - nums[idx], temp, result, idx);
        temp.remove(temp.size() - 1);
        solve(nums, target, temp, result, idx + 1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, target, new ArrayList<>(), result, 0);
        return result;
    }
}
