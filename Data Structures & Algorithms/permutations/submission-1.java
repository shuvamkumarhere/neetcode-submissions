class Solution {
    private void solve(int[] nums, List<Integer> temp, List<List<Integer>> result, List<Boolean> visited){
        if(temp.size() == nums.length){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(visited.get(i)) continue;
            temp.add(nums[i]);
            visited.set(i, true);
            solve(nums, temp, result, visited);
            temp.remove(temp.size() - 1);
            visited.set(i, false);
        } 
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(nums.length, false));
        solve(nums, temp, result, visited);
        return result;
    }
}
