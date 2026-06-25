class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int left = 0;
        int right = m;
        int totalOnOneSide = (m + n + 1) / 2;

        while (left <= right) {

            int x = left + (right - left) / 2;
            int y = totalOnOneSide - x;

            int maxLeftX =
                (x == 0) ? Integer.MIN_VALUE : nums1[x - 1];

            int minRightX =
                (x == m) ? Integer.MAX_VALUE : nums1[x];

            int maxLeftY =
                (y == 0) ? Integer.MIN_VALUE : nums2[y - 1];

            int minRightY =
                (y == n) ? Integer.MAX_VALUE : nums2[y];

            if (maxLeftX <= minRightY &&
                maxLeftY <= minRightX) {

                if ((m + n) % 2 == 0) {
                    return (
                        Math.max(maxLeftX, maxLeftY)
                        +
                        Math.min(minRightX, minRightY)
                    ) / 2.0;
                }

                return Math.max(maxLeftX, maxLeftY);
            }

            if (maxLeftX > minRightY) {
                right = x - 1;
            } else {
                left = x + 1;
            }
        }

        return 0.0;
    }
}