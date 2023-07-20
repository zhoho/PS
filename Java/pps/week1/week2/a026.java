class Solution {
    public boolean solution(int x) {
        int a = x;
        int sum = 0;
        boolean answer = true;
        while (a >= 1) {
            sum += a % 10;
            a /= 10;
        }
        if (x % sum == 0) {
            answer = true;
        } else {
            answer = false;
        }
        return answer;
    }
}