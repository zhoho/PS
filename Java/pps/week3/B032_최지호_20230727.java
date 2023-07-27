package pps.week3;

import java.util.Arrays;
import java.util.Scanner;

public class B032_최지호_20230727 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int j = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = arr[i] + j + 1;
            j++;
        }
        Arrays.sort(arr);
        System.out.println(arr[arr.length - 1] + 1);
    }
}
