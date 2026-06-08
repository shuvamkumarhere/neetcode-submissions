class Solution {

    public String encode(List<String> strs) {
        StringBuilder encoded_string = new StringBuilder();
        StringBuilder intermideateString = new StringBuilder();
        for(int i = 0; i < strs.size(); i++){
            String s = strs.get(i);
            String length = String.valueOf(s.length());
            intermideateString.setLength(0);
            intermideateString.append(length + '#');
            encoded_string.append(intermideateString + s);
        }
        System.out.println(encoded_string);
        return encoded_string.toString();
    }

    // public List<String> decode(String str) {
    //     List<String> result = new ArrayList<>();
    //     int i = 0;
    //     while(i < str.length()){
    //         StringBuilder sb = new StringBuilder();
    //         char ch = str.charAt(i);
    //         if((ch <= '9' && ch >= '0') && str.charAt(i + 1) == '#'){
    //             for(int length = 0; length < ch - '0'; length++){
    //                 sb.append(str.charAt(i + length + 2));
    //             }
    //         }
    //         result.add(sb.toString());
    //         i += ch - '0' + 2;
    //     }
    //     return result;
    // }
    public List<String> decode(String str) {
    List<String> result = new ArrayList<>();

    int i = 0;

    while (i < str.length()) {

        int j = i;

        while (str.charAt(j) != '#') {
            j++;
        }

        int length = Integer.parseInt(str.substring(i, j));

        String word = str.substring(j + 1, j + 1 + length);

        result.add(word);

        i = j + 1 + length;
    }

    return result;
}
}
