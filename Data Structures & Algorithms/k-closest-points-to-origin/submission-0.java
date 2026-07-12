class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b) -> {
            return b.get(2) - a.get(2); 
        });
        for(int [] point : points){
            pq.offer(List.of(point[0], point[1],(point[0] * point[0]) + (point[1] * point[1])));
            if(pq.size() > k){
                pq.poll();
            }
        }
        int[][] result = new int[k][2];
        for(int i = 0; i < k; i++){
            List<Integer> list = pq.poll();
            result[i][0] = list.get(0);
            result[i][1] = list.get(1);
        }
        return result;
    }
}
