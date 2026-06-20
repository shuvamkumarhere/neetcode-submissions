class MinStack {

    Deque<List<Integer>> dq = new ArrayDeque<>();
    public MinStack() {
    }
    
    public void push(int val) {
        if(!dq.isEmpty()){
            int min = dq.peek().get(1);
            min = min > val ? val : min;
            dq.push(List.of(val, min));
        } else {
            dq.push(List.of(val, val));
        }
    }
    
    public void pop() {
        dq.pop();
    }
    
    public int top() {
        return dq.peek().get(0);
    }
    
    public int getMin() {
        return dq.peek().get(1);
    }
}
