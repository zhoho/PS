package 백준.pps;

import java.util.Scanner;

public class c004 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        int ori = 0;
        int n = in.nextInt();
        ori = n;
        for (int i = 0; i < (int) (Math.log10(n) + 1); i++) {

            sum += n % 10;
            n = n / 10;

            System.out.println(i);
        }
        // System.out.println(sum);
    }
}
