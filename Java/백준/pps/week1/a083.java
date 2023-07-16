package 백준.pps.week1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class a083 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        HashSet<Integer> hs = new HashSet<Integer>();

        for (int i = 0; i < n; i++) {
            hs.add(in.nextInt());
        }
        ArrayList<Integer> arr = new ArrayList<>(hs);
        Collections.sort(arr);

        System.out.println(arr.toString().replace(",", "").replace("[", "").replace("]", ""));
    }
}
