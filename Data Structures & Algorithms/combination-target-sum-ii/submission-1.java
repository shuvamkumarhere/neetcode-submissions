class Solution {
    private void solve(int[] candidates, int target, List<List<Integer>> result, int index, List<Integer> temp){
        if(0 == target){
            result.add(new ArrayList<>(temp));
            return;
        }        
        for(int i = index; i < candidates.length; i++){
            if (candidates[i] > target) {
                break;
            }
            if(i > index && candidates[i] == candidates[i - 1]) continue;
            temp.add(candidates[i]);
            solve(candidates, target - candidates[i], result, i + 1, temp);
            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, result, 0, new ArrayList<>());
        return result;
    }
}
