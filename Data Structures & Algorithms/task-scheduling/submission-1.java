class Solution {
    public int leastInterval(char[] tasks, int n) {
        int gaps = n; // 2
        n = tasks.length; // 4
        int[] freq = new int[26]; // X = 2, Y = 2
        int max = 0; // 2
        for(int i = 0; i < n; i++){
            freq[tasks[i] - 'A']++;
            max = Math.max(freq[tasks[i] - 'A'], max);
        }
        int idleSlots = gaps * (max - 1); // 2 * 1 = 2
        boolean counted = false;

        for(int i = 0; i < 26; i++){
            if(freq[i] == max && !counted){
                counted = true;
                continue;
            }
            if(freq[i] > 0)
                idleSlots -= Math.min(freq[i], max - 1);
            if(idleSlots <= 0 ) break;
        }
        if(idleSlots == 0){
            return n;
        } else {
            return n + idleSlots;
        }
    }
}