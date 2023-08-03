class Solution {
    public boolean checkRecord(String s) {
        int a = 0;
        int b = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A') {
                a++;
                b = 0;
            } else if (s.charAt(i) == 'L')
                b++;
            else {
                b = 0;
            }
            if (a >= 2 || b >= 3)
                return false;
        }
        return true;
    }
}