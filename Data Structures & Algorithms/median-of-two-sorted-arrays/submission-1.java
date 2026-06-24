class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        int total = m + n;
        int mid1 = (total - 1) / 2;
        int mid2 = total / 2;

        int i = 0, j = 0;
        int count = 0;

        int first = 0, second = 0;

        while (count <= mid2) {

            int curr;

            if (i < m && (j >= n || nums1[i] <= nums2[j])) {
                curr = nums1[i++];
            } else {
                curr = nums2[j++];
            }

            if (count == mid1) {
                first = curr;
            }

            if (count == mid2) {
                second = curr;
            }

            count++;
        }

        return (first + second) / 2.0;
    }
}