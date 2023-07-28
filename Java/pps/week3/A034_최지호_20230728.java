package pps.week3;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class A034_최지호_20230728 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        HashSet<Integer> hash = new HashSet<Integer>();
        for (int i = 0; i < 10; i++) {
            int tmp = in.nextInt();
            tmp = tmp % 42;
            hash.add(tmp);
        }
        System.out.println(hash.size());
    }
}
