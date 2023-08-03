class Solution {
    public boolean halvesAreAlike(String s) {
        int a = 0;
        int b = 0;
        s = s.toUpperCase();
        for (int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O'
                    || s.charAt(i) == 'U')
                a++;
        }
        for (int i = s.length() / 2; i < s.length(); i++) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'E' || s.charAt(i) == 'I' || s.charAt(i) == 'O'
                    || s.charAt(i) == 'U')
                b++;
            System.out.println(i);
        }

        if (a == b)
            return true;
        return false;
    }
}