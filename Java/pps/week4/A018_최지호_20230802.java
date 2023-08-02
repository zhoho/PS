package pps.week4;

import java.util.Arrays;
import java.util.Scanner;

public class A018_최지호_20230802 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }
        Arrays.sort(a);
        Arrays.sort(b);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i] * b[n - i - 1];
        }
        System.out.print(sum);
    }
}
