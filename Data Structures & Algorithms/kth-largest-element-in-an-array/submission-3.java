class Solution {
    private int partition(int [] nums, int left, int right){
        int pivot = nums[left];
        int i = left + 1, j = right;
        while(i <= j){
            while(i <= j && nums[i] >= pivot) i++;
            while(i <= j && nums[j] < pivot) j--;
            if(i < j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j--;
            }
        }
        int temp = nums[left];
        nums[left] = nums[j];
        nums[j] = temp;
        return j;
    }
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int pivot_idx = 0;
        while(true){
            pivot_idx = partition(nums, left, right);
            if(pivot_idx == k - 1){
                break;
            } else if(pivot_idx < k - 1){
                left = pivot_idx + 1;
            } else {
                right = pivot_idx - 1;
            }
        }
        return nums[pivot_idx];
    }
}
