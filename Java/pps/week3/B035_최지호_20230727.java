class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] arr = new int[n];

        for (int i = 0; i < lost.length; i++) {
            arr[lost[i] - 1] -= 1;
        }
        for (int i = 0; i < reserve.length; i++) {
            arr[reserve[i] - 1] += 1;
        }
        // 첫번째 요소 확인
        if (arr[0] == -1) {
            if (arr[1] == 1) {
                arr[0] += 1;
                arr[1] -= 1;
            }
        }
        // 중간 요소 확인
        for (int i = 1; i < n - 1; i++) {
            if (arr[i] == -1) {
                if (arr[i - 1] == 1) {
                    arr[i] += 1;
                    arr[i - 1] -= 1;
                } else if (arr[i + 1] == 1) {
                    arr[i] += 1;
                    arr[i + 1] -= 1;
                }
            }
        }
        // 마지막 요소 확인
        if (arr[n - 1] == -1) {
            if (arr[n - 2] == 1) {
                arr[n - 1] += 1;
                arr[n - 2] -= 1;
            }
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                answer += 1;
            }
        }
        return answer;
    }
}