class Solution {
    public int leastInterval(char[] tasks, int n) {

        int[] freq = new int[26];

        for (char task : tasks)
            freq[task - 'A']++;

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Comparator.reverseOrder());

        for (int f : freq)
            if (f > 0)
                pq.offer(f);

        int time = 0;

        while (!pq.isEmpty()) {

            List<Integer> remaining = new ArrayList<>();

            int cycle = n + 1;

            while (cycle > 0 && !pq.isEmpty()) {

                int count = pq.poll();

                if (count > 1)
                    remaining.add(count - 1);

                time++;
                cycle--;
            }

            for (int x : remaining)
                pq.offer(x);

            if (pq.isEmpty())
                break;

            time += cycle; // idle slots
        }

        return time;
    }
}