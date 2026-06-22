class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1, right = n - 1;
        while(left >= 0 && right >= 0){
            if(nums2[right] >= nums1[left]){
                nums1[left + right + 1] = nums2[right];
                right--;
            } else {
                nums1[left + right + 1] = nums1[left];
                left--;
            }
        }
        while(right >= 0) {
            nums1[left + right + 1] = nums2[right];
            right--;
        }
    }
}

