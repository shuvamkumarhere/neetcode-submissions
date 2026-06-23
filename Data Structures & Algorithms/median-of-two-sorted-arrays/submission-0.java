class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length, i = 0, j = 0, k = 0;
        int[] temp = new int[m + n];
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }
        while(i < m){
            temp[k++] = nums1[i++];
        }
        while(j < n){
            temp[k++] = nums2[j++];
        }
        return (m + n) % 2 != 0 ? temp[(m + n) / 2] : (temp[(m + n) / 2] + temp[((m + n) / 2) - 1]) / 2.0;
    }
}
