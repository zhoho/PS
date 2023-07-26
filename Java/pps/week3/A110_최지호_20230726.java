package pps.week3;

import java.util.Scanner;

public class A110_최지호_20230726 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int res = 0;
        n = 1000 - n;
        if (n >= 500) {
            n -= 500;
            res++;
        }
        if (n >= 100) {
            int tmp = n / 100;
            res += tmp;
            n = n % 100;
        }
        if (n >= 50) {
            int tmp = n / 50;
            res += tmp;
            n = n % 50;
        }
        if (n >= 10) {
            int tmp = n / 10;
            res += tmp;
            n = n % 10;
        }
        if (n >= 5) {
            int tmp = n / 5;
            res += tmp;
            n = n % 5;
        }
        res += n;
        System.out.println(res);
    }
}
