class Solution {
    public List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<Integer>();
        for (int i = left; i <= right; i++) {
            int tmp = i;
            boolean chk = true;
            while (tmp > 0) {
                int remain = tmp % 10;
                tmp /= 10;
                if ((remain == 0) || (i % remain) != 0) {
                    chk = false;
                    break;
                }
            }
            if (chk == true)
                list.add(i);
        }
        return list;
    }
}