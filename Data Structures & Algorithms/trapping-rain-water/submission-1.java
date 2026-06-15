class Solution {
    public int trap(int[] height) {
        int n = height.length;

        List<Integer> preMax = new ArrayList<>();
        List<Integer> postMax = new ArrayList<>();

        preMax.add(0);
        postMax.add(0);

        for (int i = 1; i < n; i++) {

            preMax.add(
                Math.max(
                    preMax.get(i - 1),
                    height[i - 1]
                )
            );

            postMax.add(
                Math.max(
                    postMax.get(i - 1),
                    height[n - i]
                )
            );
        }

        int totalWater = 0;

        for (int i = 0; i < n; i++) {

            int leftMax = preMax.get(i);
            int rightMax = postMax.get(n - 1 - i);

            int water = Math.min(leftMax, rightMax) - height[i];

            if (water > 0) {
                totalWater += water;
            }
        }

        return totalWater;
    }
}