package 백준.pps.week1;

import java.util.Scanner;

public class a021 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int plug = in.nextInt();
            sum += plug;
        }
        System.out.println(sum - (n - 1));
    }
}
