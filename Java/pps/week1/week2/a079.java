import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] arr = array;
            int[] arr1 = Arrays.copyOfRange(arr, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(arr1);
            answer[i] = arr1[commands[i][2] - 1];
        }
        return answer;
    }
}