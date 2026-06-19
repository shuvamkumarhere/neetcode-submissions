class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> dq = new ArrayDeque<>();
        for(int i = 0; i < nums.length; i++){
            int curr = nums[i];
            while(!dq.isEmpty() && nums[dq.peekLast()] < curr){
                dq.pollLast();
            }
            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }
            dq.addLast(i);
            if(i >= k - 1){
                result[i - k  + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
