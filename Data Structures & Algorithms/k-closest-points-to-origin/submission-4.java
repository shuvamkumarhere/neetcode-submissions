class Solution {

    private long distance(int[][] points, int idx) {
        return 1L * points[idx][0] * points[idx][0]
             + 1L * points[idx][1] * points[idx][1];
    }

    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }

    private int partition(int[][] points, int left, int right) {
        long pivotDist = distance(points, left);
        int i = left + 1;
        int j = right;

        while (i <= j) {

            while (i <= j && distance(points, i) <= pivotDist) {
                i++;
            }

            while (i <= j && distance(points, j) > pivotDist) {
                j--;
            }

            if (i < j) {
                swap(points, i, j);
                i++;
                j--;
            }
        }

        swap(points, left, j);
        return j;
    }

    public int[][] kClosest(int[][] points, int k) {

        int left = 0;
        int right = points.length - 1;

        while (true) {
            int pivot = partition(points, left, right);

            if (pivot == k - 1) {
                break;
            } else if (pivot < k - 1) {
                left = pivot + 1;
            } else {
                right = pivot - 1;
            }
        }

        int[][] ans = new int[k][2];
        System.arraycopy(points, 0, ans, 0, k);
        return ans;
    }
}