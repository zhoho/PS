package pps.week1;

import java.util.Scanner;

public class a050 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String word = in.next();
        int len_word = word.length();
        char[] arr = new char[len_word];

        for (int i = 0; i < len_word; i++) {
            if (word.charAt(i) <= 67) {
                arr[i] = (char) (word.charAt(i) + 23);
            } else {
                arr[i] = (char) (word.charAt(i) - 3);
            }
        }
        System.out.println(arr);

    }
}
