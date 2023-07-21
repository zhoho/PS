// Time limit

// class Solution {
// public int countPrimes(int n) {
// if(n == 0) return 0;
// if(n == 1) return 0;
// int ans = 0;
// for(int i = 2; i < n; i ++)
// {
// int check = 0;
// for(int j = 1; j < i; j++)
// {
// if(i % j == 0) check += 1;
// }
// if(check == 1) ans += 1;
// }
// return ans;
// }
// }
