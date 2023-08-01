class Solution {
    public boolean lemonadeChange(int[] bills) {
        int chk5 = 0;
        int chk10 = 0;
        for (int i = 0; i < bills.length; i++) {
            if (bills[i] == 5)
                chk5++;
            else if (bills[i] == 10) {
                if (chk5 == 0)
                    return false;
                chk5--;
                chk10++;
            } else if (bills[i] == 20) {
                if (chk10 >= 1 && chk5 >= 1) {
                    chk10--;
                    chk5--;
                } else if (chk5 >= 3)
                    chk5 -= 3;
                else
                    return false;
            }
        }
        return true;
    }
}