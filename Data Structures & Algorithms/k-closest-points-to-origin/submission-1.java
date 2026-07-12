class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Long.compare(
            1L * b[0] * b[0] + 1L * b[1] * b[1],
            1L * a[0] * a[0] + 1L * a[1] * a[1]
        ));
        for(int [] point : points){
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            result[i] = pq.poll();
        }
        return result;
    }
}
