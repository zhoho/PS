package 백준;

import java.util.Scanner;

public class b3062 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int sum = n;
            int sumlen = (int) (Math.log10(sum));
            while (n > 0) {
                sum += (n % 10) * Math.pow(10, sumlen);
                n /= 10;
                sumlen--;
            }
            int reverse = sum;
            int tmp = 0;
            sumlen = (int) (Math.log10(sum));
            while (sum > 0) {
                tmp += (sum % 10) * Math.pow(10, sumlen);
                // System.out.println("tmp : " + tmp + " sum : " + sum + " sumlen : " + sumlen);
                sum /= 10;
                sumlen--;
            }
            if (reverse == tmp)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
