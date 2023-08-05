class Solution {
    public int heightChecker(int[] heights) {
        int[] arr = heights.clone();
        Arrays.sort(arr);
        int match = 0;
        for (int i = 0; i < heights.length; i++) {
            if (arr[i] != heights[i])
                match++;
        }
        return match;
    }
}