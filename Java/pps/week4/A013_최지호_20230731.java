class Solution {
    public int singleNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                list.remove(Integer.valueOf(nums[i]));
            } else {
                list.add(nums[i]);
            }
        }
        return list.get(0);
    }
}