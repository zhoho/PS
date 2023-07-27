package pps.week3;

import java.util.Scanner;

public class B036_최지호_20230727 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int res = 0;
        int[] coin = new int[n];
        for (int i = 0; i < n; i++) {
            coin[i] = in.nextInt();
        }

        for (int i = coin.length - 1; i >= 0; i--) {
            if (k / coin[i] >= 1) {
                res += k / coin[i];
                k = k % coin[i];
            }
        }
        System.out.println(res);
    }
}
