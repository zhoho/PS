package pps.week3;

import java.util.Scanner;

public class A052_최지호_20230727 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = new String[in.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = in.next();
            int count = 0;
            int sum = 0;
            for (int j = 0; j < arr[i].length(); j++) {
                if (arr[i].charAt(j) == 'O') {
                    count++;
                } else {
                    count = 0;
                }
                sum += count;
            }
            System.out.println(sum);
        }
    }
}
