class Solution {
    public int[] productExceptSelf(int[] nums) {
        int mult = 1;
        int numZeros = 0;
        int index = -1;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) mult *= nums[i];
            else {
                numZeros++;
                index = i;
            }
        }

        int[] result = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            if (numZeros > 1) result[i] = 0;
            else if (numZeros == 1) {
                if (i == index) result[i] = mult;
                else result[i] = 0;
            } else {
                result[i] = mult/nums[i];
            }
        }
        return result;
    }
}  
