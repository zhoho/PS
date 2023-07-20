package pps.week1.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class c071 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();
        int n = Integer.parseInt(in.readLine());
        StringTokenizer st = new StringTokenizer(in.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = arr[0];
        int end = 0;
        int max = 0;
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[i - 1]) {
                end = arr[i];
                if (end - start > max)
                    max = end - start;
            } else {
                start = arr[i];
            }
        }
        System.out.println(max);
    }
}
