class Solution {
    public int evalRPN(String[] tokens) {
        int n = tokens.length;
        Deque<String> dq = new ArrayDeque<>();
        for(int i = 0; i < n; i++){
            String token = tokens[i];
            if(!(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"))){
                dq.push(token);
            } else {
                int first = Integer.valueOf(dq.pop());
                int second = Integer.valueOf(dq.pop());
                int result = -1;
                if(token.equals("+")){
                    result = second + first;
                } else if(token.equals("-")){
                    result = second - first;
                } else if(token.equals("*")){
                    result = second * first;
                } else if(token.equals("/")){
                    result = second / first;
                }
                String strResult = String.valueOf(result);
                dq.push(strResult);
            }
        }
        return Integer.valueOf(dq.pop());
    }
}
