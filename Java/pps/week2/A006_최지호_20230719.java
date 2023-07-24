class Solution {
    boolean solution(String s) {
        boolean answer = true;
        int p = 0;
        int y = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'p' || c == 'P')
                p += 1;
            else if (c == 'y' || c == 'Y')
                y += 1;
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("Hello Java");
        if (y != p)
            answer = false;
        return answer;
    }
}