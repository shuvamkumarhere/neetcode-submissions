class Solution {
    public int trap(int[] height) {        
        List<Integer> preMax = new ArrayList<>();
        List<Integer> postMax = new ArrayList<>();
        int n = height.length;
        preMax.add(0);
        postMax.add(0);
        for(int i = 1; i < n; i++){
            if(preMax.get(i - 1) < height[i - 1]){
                preMax.add(height[i - 1]);
            } else {
                preMax.add(preMax.get(i - 1));
            }
            if(postMax.get(i - 1) < height[n - i]){
                postMax.add(height[n - i]);
            } else {
                postMax.add(postMax.get(i - 1));
            }
        }
        int totalWater = 0;
        for(int i = 0; i < n; i++){
            int water = Math.min(preMax.get(i), postMax.get(n - i - 1)) - height[i];
            totalWater += water > 0 ? water : 0;

        }
        return totalWater;
    }
}
