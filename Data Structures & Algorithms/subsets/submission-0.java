class Solution {
    private void solve(int[] nums, int idx, List<Integer> temp, List<List<Integer>> result){
        if(idx == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        solve(nums, idx + 1, temp, result);
        temp.add(nums[idx]);
        solve(nums, idx + 1, temp, result);
        temp.remove(temp.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), result); 
        return result;
    }
}
