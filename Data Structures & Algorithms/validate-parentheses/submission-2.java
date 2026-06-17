class Solution {
    public boolean isValid(String s) {
        Stack<Character> deque = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            Character ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '['){
                deque.push(ch);
            } else if ( (ch == ')' && !deque.isEmpty() &&deque.peek() == '(') 
            || (ch == '}' && !deque.isEmpty() && deque.peek() == '{') 
            || (ch == ']' && !deque.isEmpty() && deque.peek() == '[')){
                deque.pop();
                continue;
            } else return false;
        }
        if(!deque.isEmpty()) return false;
        return true;
    }
}
