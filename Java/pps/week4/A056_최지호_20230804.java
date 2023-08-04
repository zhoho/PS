class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] list = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            int tmp = 0;
            boolean chk = false;
            int num = 0;
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    tmp = nums1[i];
                    num = j;
                    break;
                }
            }
            for (int k = num; k < nums2.length; k++) {
                if (nums2[k] > nums1[i]) {
                    list[i] = nums2[k];
                    chk = true;
                    break;
                }
            }
            if (chk == false)
                list[i] = -1;
        }
        return list;
    }
}