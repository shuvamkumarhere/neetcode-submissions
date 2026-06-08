class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        Integer [] arr = new Integer[map.size()];
        int i = 0;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            arr[i] = entry.getKey();
            i++;
        }
        Arrays.sort(arr, (a,b) -> {
            int freqA = map.get(a);
            int freqB = map.get(b);
            return freqB - freqA;
        });
        int[] result = new int[k];
        for(int j = 0; j < k; j++){
            result[j] = arr[j];
        }
        return result;
    }
}
