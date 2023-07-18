package pps.week1;

import java.util.Scanner;

public class a015 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int sum = 0;
        for (int i = 0; i < 5; i++) {
            int temp = in.nextInt();
            sum += temp * temp;
        }
        System.out.println(sum % 10);
    }
}
