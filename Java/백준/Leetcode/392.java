class Solution {
    public boolean isSubsequence(String s, String t) {
        int cnt = 0;
        for (int i = 0; i < t.length(); i++) {
            if (cnt >= s.length())
                break;
            if (t.charAt(i) == s.charAt(cnt))
                cnt++;
        }
        if (cnt == s.length())
            return true;
        return false;
    }
}