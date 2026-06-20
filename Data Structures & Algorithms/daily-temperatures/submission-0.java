class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<List<Integer>> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; i++){
            if(stack.isEmpty() || 
            (!stack.isEmpty() && stack.peek().get(0) > temperatures[i])
            ){
                stack.push(Arrays.asList(temperatures[i], i));
            } else {
                while(!stack.isEmpty() && stack.peek().get(0) < temperatures[i]){
                    int idx = stack.pop().get(1);
                    result[idx] = i - idx;
                }
                stack.push(Arrays.asList(temperatures[i], i));
            }
        }
        return result;
    }
}

//38 30 