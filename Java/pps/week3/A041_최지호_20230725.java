class Solution {
    public String solution(String s) {
        String answer = "";
        String[] arr = s.split(" ");
        for (int i = 0; i < arr.length; i++) {
            String tmp = arr[i];
            if (arr[i].length() == 0) {
                answer += " ";
            } else {
                answer += tmp.substring(0, 1).toUpperCase();
                answer += tmp.substring(1, tmp.length()).toLowerCase();
                answer += " ";
            }

        }
        // 받은 문자열의 마지막이 공백이면 그대로 출력
        if (s.substring(s.length() - 1, s.length()).equals(" ")) {
            return answer;
        }
        // 아니라면 마지막 공백삭제
        return answer.substring(0, answer.length() - 1);
    }
}