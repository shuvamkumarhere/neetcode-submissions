class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int stone: stones){
            pq.offer(stone);
        }
        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();
            if(second != first){
                pq.offer(Math.abs(second - first));
            }
        }
        return pq.size() == 1 ? pq.peek() : 0;
    }
}
