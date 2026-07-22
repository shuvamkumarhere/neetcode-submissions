class Solution {
    private void solve(int[] nums, List<List<Integer>> result, List<Integer> temp, int idx){
        result.add(new ArrayList<>(temp));
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]){
                continue;
            }
            temp.add(nums[i]);
            solve(nums, result, temp, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums, result, temp, 0);
        return result;
    }
}
