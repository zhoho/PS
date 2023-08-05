class Solution {
    public String solution(int a, int b) {
        String answer = "";
        String[] day = { "FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU" };
        int[] date = { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        int totaldate = 0;
        for (int i = 0; i < a - 1; i++) {
            totaldate += date[i];
        }
        totaldate += (b - 1);
        answer = day[totaldate % 7];

        return answer;
    }
}