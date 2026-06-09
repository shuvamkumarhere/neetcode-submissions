class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int post = 1;
        output[0] = 1;
        for(int i = 1; i < nums.length; i++){
            output[i] = output[i - 1] * nums[i - 1];
        }
        output[nums.length - 1] *= post;
        for(int i = nums.length - 2; i >= 0; i--){
            post = post * nums[i + 1];
            output[i] = output[i] * post;
        } 
        return output;
    }
}  
 // 1 1 2 8
 //.      1