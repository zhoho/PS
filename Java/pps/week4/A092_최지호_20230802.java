class Solution {
    public int[] sortArrayByParityII(int[] nums) {
        int[] arr = new int[nums.length];

        int odd = 1;
        int even = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                arr[even] = nums[i];
                even += 2;
            } else {
                arr[odd] = nums[i];
                odd += 2;
            }
        }
        return arr;
    }
}
