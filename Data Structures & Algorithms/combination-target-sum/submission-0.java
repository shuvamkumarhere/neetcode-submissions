class Solution {
    private void solve(int[] nums, int target, List<Integer> temp, int sum, List<List<Integer>> result, int idx){
        if(idx == nums.length || sum > target){
            if(sum == target)
                result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[idx]);
        solve(nums, target, temp, sum + nums[idx], result, idx);
        temp.remove(temp.size() - 1);
        solve(nums, target, temp, sum, result, idx + 1);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, target, new ArrayList<>(), 0, result, 0);
        return result;
    }
}
