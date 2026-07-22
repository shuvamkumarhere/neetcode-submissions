class Solution {
    private void solve(int[] nums, List<List<Integer>> result, List<Integer> temp, List<Boolean> visited, int idx){
        result.add(new ArrayList<>(temp));
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1]){
                continue;
            }
            temp.add(nums[i]);
            visited.set(i, true);
            solve(nums, result, temp, visited, i + 1);
            visited.set(i, false);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(nums.length, false));
        solve(nums, result, temp, visited, 0);
        return result;
    }
}
