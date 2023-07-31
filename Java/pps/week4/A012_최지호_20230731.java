class Solution {
    public int countPrimes(int n) {
        int count = 0;

        boolean[] prime = new boolean[n];

        for (int i = 2; i < n; i++) {
            if (!prime[i]) {
                count++;
                int tmp = 1;
                while (i * tmp < n) {
                    prime[i * tmp] = true;
                    tmp++;
                }
            }
        }
        return count;
    }
}