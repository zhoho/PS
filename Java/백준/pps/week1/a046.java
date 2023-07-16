package 백준.pps.week1;

import java.util.Scanner;

public class a046 {
    public static void main(String[] args) {
        int[] ascii = new int[26];
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String name = in.next();
            char first = name.charAt(0);
            ascii[first - 97]++;
            // a ascii = 97
        }
        boolean checker = false;
        for (int i = 0; i < ascii.length; i++) {
            if (ascii[i] >= 5) {
                checker = true;
                System.out.print((char) (i + 97));
            }
        }
        if (!checker) {
            System.out.println("PREDAJA");
        }
    }
}
