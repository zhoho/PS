package pps.week3;

import java.util.Scanner;

public class B031_최지호_20230727 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        int n = in.nextInt();
        int min = a - b;
        int cnt = 0;
        if (min < 0) {
            min *= -1;
        }
        for (int i = 0; i < n; i++) {
            int star = in.nextInt();
            int tmp = star - b;
            if (tmp < 0) {
                tmp *= -1;
            }
            if (min > tmp) {
                min = tmp;
                cnt++;
            }
        }
        if (min < 0) {
            min *= -1;
        }
        if (cnt == 0) {
            System.out.println(min);
        } else {
            System.out.println(min + 1);
        }
    }
}
