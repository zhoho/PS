package pps.week3;

import java.util.Scanner;

public class C034_최지호_20230724 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        while (n >= 0) {
            if (n % 5 == 0) {
                res += n / 5;
                System.out.println(res);
                break;
            }
            n -= 3;
            res += 1;
        }
        if (n < 0) {
            System.out.println("-1");
        }
    }
}
