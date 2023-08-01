class Solution {
    public int addDigits(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
            if (sum > 9 && num == 0) {
                num = sum;
                sum = 0;
            }
        }
        return sum;
    }
}
// ex) 38
// sum = 8
// num = 3

// sum = 8 + 3;
// num = 0;

// num = 11;
// sum = 0;

// sum = 1;
// num = 1;

// sum = 2
// num = 0;