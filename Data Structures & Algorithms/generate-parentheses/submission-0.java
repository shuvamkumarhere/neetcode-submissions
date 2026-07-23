class Solution {
    private void solve(int n, List<String> result, StringBuilder sb, int openCount, int closeCount){
        if(sb.length() == 2 * n){
            result.add(sb.toString());
            return;
        }
        if(openCount == 0 || openCount == closeCount){
            solve(n, result, sb.append('('), openCount + 1, closeCount);
            sb.deleteCharAt(sb.length() - 1);
        } else {
            if(openCount < n){
                solve(n, result, sb.append("("), openCount + 1, closeCount);
                sb.deleteCharAt(sb.length() - 1);
            }
            if(closeCount != openCount && closeCount < n){
                solve(n, result, sb.append(")"), openCount, closeCount + 1);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve(n, result, new StringBuilder(), 0, 0);
        return result;
    }
}
