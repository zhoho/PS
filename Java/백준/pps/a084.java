package 백준.pps;

import java.util.Arrays;
import java.util.Scanner;

public class a084 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        int len_word = word.length();
        String[] arr = new String[len_word];

        for (int i = 0; i < len_word; i++) {
            arr[i] = word.substring(i, len_word);
        }
        Arrays.sort(arr);
        for (int i = 0; i < len_word; i++) {
            System.out.println(arr[i]);
        }
    }
}
